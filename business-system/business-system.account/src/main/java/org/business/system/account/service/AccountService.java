package org.business.system.account.service;

import java.math.BigDecimal;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.Account;

public interface AccountService extends BaseService<Account, Long>{
	
	/**
	 * 通过账户绑定Id和账户类型获取账户信息
	 * @param accountId
	 * @param accountType
	 * @return
	 */
	public Account selectAccountByAccountIdAndType(Long accountId,String accountType);
	
	/**
	 * 新增账户信息
	 * @param account
	 * @return
	 */
	public Account newAccount(Account account);
	
	
	/**
	 * 
	 * @param accountId  账户ID
	 * @param accountType 账户类型
	 * @param amount //账户操作金额
	 * @param opType //操作类型
	 * @return
	 */
	public Account accountAddAndReduce(Long accountId,String accountType,BigDecimal amount,String opType);

}
