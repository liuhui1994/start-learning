package org.business.system.account.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.business.system.account.exception.AccountException;
import org.business.system.account.mapper.AccountMapper;
import org.business.system.account.model.Account;
import org.business.system.account.service.AccountService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.notice.NoticeCloudService;
import org.business.system.common.em.AccountState;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Long> implements AccountService {
	
	@Autowired
	private AccountMapper  accountMapper;
	
	@Autowired
	private NoticeCloudService noticeCloudService;

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
		if(account.getAccountState().name().equals("freez")) {
			throw new AccountException("02", "账户被冻结");
		}
		return account;
	}

	@Override
//	@TxTransaction
	@Transactional
	public Account newAccount(Account account) {
		Account newAccount  = new Account();
		newAccount.setAccountId(account.getAccountId());
		newAccount.setAccountType(account.getAccountType());
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
			throw  new CommonErrorException("00", "创建账户失败");
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
			throw new CommonErrorException("01", "账户不存在");
		}
		
		//账户安全校验
		String updateFiled = account.getUpdateField();
		String verifyField = Md5.encode(account.getAccountId()+account.getAccountType()+account.getAmount()+account.getWithdrawalAmount()
		+account.getSettlementAmount()+account.getUpdateDate().getTime()/1000);
		if(!updateFiled.equals(verifyField)) {
			throw new CommonErrorException("02", "账户安全校验未通过");
		}
		
		if(amount!=null && amount.compareTo(new BigDecimal("0.00"))<0) {
			throw new CommonErrorException("03", "账户操作金额必须大于0");
		}
		
		if(opType !=null && opType.equals("order")) {
		    account.setAmount(account.getAmount().add(amount));
		    account.setUpdateDate(new Date());
		    account.setUpdateField(Md5.encode(account.getAccountId()+account.getAccountType()+account.getAmount()+account.getWithdrawalAmount()
			+account.getSettlementAmount()+account.getUpdateDate().getTime()/1000));
		   success = accountMapper.updateByLock(account);
		   if(success<=0) {
			   throw  new CommonErrorException("00", "账户信息修改失败");  
		   }
		}
		if(noticeCloudService.putUser(1L) == null) {
			throw new CommonErrorException("01", "服务调用失败!");
		}
		return account;
	}

}
