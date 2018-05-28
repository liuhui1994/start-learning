package org.business.system.account.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.business.system.account.exception.AccountException;
import org.business.system.account.mapper.AccountMapper;
import org.business.system.account.model.Account;
import org.business.system.account.service.AccountService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Long> implements AccountService {
	
	@Autowired
	private AccountMapper  accountMapper;

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
		if(account.getAccountState()==1) {
			throw new AccountException("02", "账户被冻结");
		}
		return account;
	}

	@Override
	public Account newAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Account accountAddAndReduce(Long accountId, String accountType, BigDecimal amount, String opType) {
		Account account = selectAccountByAccountIdAndType(accountId, accountType);
		if(account == null) {
			throw new AccountException("01", "账户不存在");
		}
		return null;
	}

}
