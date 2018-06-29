package org.business.system.account.mapper;

import java.util.List;

import org.business.system.account.model.AccountFlow;
import org.business.system.account.model.AccountFlowDto;
import org.business.system.common.configuration.BaseMapper;

import tk.mybatis.mapper.entity.Example;

public interface AccountFlowMapper extends BaseMapper<AccountFlow> {
	
	public List<AccountFlowDto> selectAccountFlowDtoListByExample(Example example);
}
