package org.business.system.account.service;

import java.util.List;

import org.business.system.account.model.AccountFlow;
import org.business.system.account.model.AccountFlowDto;
import org.business.system.common.base.service.BaseService;

public interface AccountFlowService extends BaseService<AccountFlow, Long>{
	
	/**
	 * 通过dto获取流水列表
	 * @param accountFlowDto
	 * @return
	 */
	List<AccountFlowDto> getAccountFlowListByDao(AccountFlowDto accountFlowDto);

}
