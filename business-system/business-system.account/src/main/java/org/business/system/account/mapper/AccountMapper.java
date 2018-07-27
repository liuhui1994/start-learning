package org.business.system.account.mapper;

import org.business.system.common.configuration.BaseMapper;
import org.business.system.common.model.Account;

public interface AccountMapper extends BaseMapper<Account> {
	
    public  int updateByLock(Account account);
}
