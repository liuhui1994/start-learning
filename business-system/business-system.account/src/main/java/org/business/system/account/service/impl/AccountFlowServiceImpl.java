package org.business.system.account.service.impl;

import java.util.List;

import org.business.system.account.mapper.AccountFlowMapper;
import org.business.system.account.model.AccountFlow;
import org.business.system.account.model.AccountFlowDto;
import org.business.system.account.service.AccountFlowService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AccountFlowServiceImpl extends BaseServiceImpl<AccountFlow, Long> implements AccountFlowService{
	
	@Autowired
	private AccountFlowMapper  accountFlowMapper;

	@Override
	public List<AccountFlowDto> getAccountFlowListByDao(AccountFlowDto accountFlowDto) {
		Example example = createExample(accountFlowDto);
		return accountFlowMapper.selectAccountFlowDtoListByExample(example);
	}
	
	/**
	 * 生成查询的example
	 * @param accountFlowDto
	 * @return
	 */
	private Example createExample(AccountFlowDto accountFlowDto){
		Example example = new Example(Notice.class);
        Criteria criteria = example.createCriteria();
		criteria.andEqualTo("status", BooleanType.FALSE);
		
		if(accountFlowDto!=null && accountFlowDto.getAccountId()!=null) {
			criteria.andEqualTo("accountId", accountFlowDto.getAccountId());
		}
		
		return example;
	}

}
