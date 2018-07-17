package org.business.system.account.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.business.system.account.constants.AccountConstants;
import org.business.system.account.mapper.AccountFlowMapper;
import org.business.system.account.mapper.AccountMapper;
import org.business.system.account.model.AccountFlow;
import org.business.system.account.service.AccountService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.notice.NoticeCloudService;
import org.business.system.common.constants.GlobalConstants;
import org.business.system.common.em.AccountState;
import org.business.system.common.em.TradeType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.Account;
import org.business.system.common.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Long> implements AccountService {
	
	@Autowired
	private AccountMapper  accountMapper;
	
	@Autowired
	private NoticeCloudService noticeCloudService;
	
	@Autowired
	private AccountFlowMapper accountFlowMapper;

	@Override
	public Account selectAccountByAccountIdAndType(Long accountId, String accountType) {
		Example example = new Example(Account.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("accountId", accountId)
		        .andEqualTo("accountType", accountType); //accountid+accounttype 加唯一索引
		List<Account> accountList = accountMapper.selectByExample(example);
		if(accountList==null || accountList.isEmpty()) {
			return null;
		}
		Account account = accountList.get(0);
		if(!account.getAccountState().name().equals("USE")) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_FREEZ,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_FREEZ);
		}
		return account;
	}

	@Override
//	@TxTransaction
	@Transactional
	public Account newAccount(Account account) {
		Long accountId = account.getAccountId();
		String accountType = account.getAccountType();
		if(ObjectUtils.isEmpty(accountId)) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_USER_SIGN,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_USER_SIGN);
		}
		if(ObjectUtils.isEmpty(accountType)) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_TYPE_NOT_NULL,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_TYPE_NOT_NULL);
		}
		Account newAccount  = new Account();
		newAccount.setAccountId(accountId);
		newAccount.setAccountType(accountType);
		newAccount.setAmount(new BigDecimal("0.00"));
		newAccount.setWithdrawalAmount(new BigDecimal("0.00"));
		newAccount.setSettlementAmount(new BigDecimal("0.00"));
		Date date = new Date();
		newAccount.setUpdateDate(date);
		newAccount.setUpdateField(Md5.encode(newAccount.getAccountId()+newAccount.getAccountType()+newAccount.getAmount()+newAccount.getWithdrawalAmount()
		+newAccount.getSettlementAmount()+newAccount.getUpdateDate().getTime()/1000));
		newAccount.setVersion(0L);
		newAccount.setAccountState(AccountState.USE);
		int success = accountMapper.insertSelective(newAccount);
		if(success<=0) {
			throw  new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_CREATE_FAIL,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_CREATE_FAIL);
		}
		return newAccount;
	}

	@Override
	@Transactional
//	@TxTransaction(isStart=true)
	public Account accountAddAndReduce(Long accountId, String accountType, BigDecimal amount, String opType) {
		int success = 0;
		Account account = selectAccountByAccountIdAndType(accountId, accountType);
		if(account == null) {
			throw  new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_EXIST,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_EXIST);
		}
		
		//账户安全校验
		String updateFiled = account.getUpdateField();
		String verifyField = Md5.encode(account.getAccountId()+account.getAccountType()+account.getAmount()+account.getWithdrawalAmount()
		+account.getSettlementAmount()+account.getUpdateDate().getTime()/1000);
		if(!updateFiled.equals(verifyField)) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_SECURITY,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_SECURITY);
		}
		
		if(amount!=null && amount.compareTo(new BigDecimal("0.00"))<0) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_AMOUNT_OP,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_AMOUNT_OP);
		}
		if(!account.getAccountState().name().equals("USE")) {
			throw new CommonErrorException(AccountConstants.EXCEPTION_CODE_ACCOUNT_FREEZ,
					AccountConstants.EXCEPTION_MESSGAE_ACCOUNT_FREEZ);
		}
		//金额操作+
		if(opType !=null && opType.equals(TradeType.RECHANGR.name())) { //充值
		    account.setAmount(account.getAmount().add(amount));
		}
		//金额操作-
		if(opType !=null && opType.equals(TradeType.WITHDRAWAL.name())){ //提现
		    account.setWithdrawalAmount(account.getWithdrawalAmount().subtract(amount));
		}
	    account.setUpdateDate(new Date());
	    account.setUpdateField(Md5.encode(account.getAccountId()+account.getAccountType()+account.getAmount()+account.getWithdrawalAmount()
		+account.getSettlementAmount()+account.getUpdateDate().getTime()/1000));
	    success = accountMapper.updateByLock(account);
	    if(success<=0) {
			throw new CommonErrorException(GlobalConstants.SERVICE_INVOKE_EXCEPTION_CODE,
					GlobalConstants.SERVICE_EXCEPTION_MESSAGE);
	    }
	    //新增账户流水
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setAccountId(accountId);
        accountFlow.setAmount(amount);
        accountFlow.setCreateDate(new Date());
        accountFlow.setRemainAmount(account.getAmount());
        accountFlow.setFlowType(opType);
        accountFlow.setRemark("备注");
        accountFlow.setTradeId(1L);  //关联交易id
        success = accountFlowMapper.insertSelective(accountFlow);
	    if(success<=0) {
			throw new CommonErrorException(GlobalConstants.SERVICE_INVOKE_EXCEPTION_CODE,
					GlobalConstants.SERVICE_EXCEPTION_MESSAGE);
	    }
		return account;
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = format.parse("2018-06-10 17:21:58").getTime()/1000;
		System.out.println();
		System.out.println(Md5.encode("1000"+"USER"+"100"+"00"+time));
	}

}
