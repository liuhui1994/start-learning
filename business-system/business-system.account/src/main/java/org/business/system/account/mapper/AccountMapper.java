package org.business.system.account.mapper;

import org.business.system.account.model.Account;
import org.business.system.common.configuration.BaseMapper;

public interface AccountMapper extends BaseMapper<Account> {
	
    public  int updateByLock(Account account);
}
