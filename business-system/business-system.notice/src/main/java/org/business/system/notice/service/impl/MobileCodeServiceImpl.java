package org.business.system.notice.service.impl;

import java.util.List;

import org.business.system.notice.ecception.ValidateCodeException;
import org.business.system.notice.mapper.MobileCodeMapper;
import org.business.system.notice.model.MobileCode;
import org.business.system.notice.service.MobileCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class MobileCodeServiceImpl implements MobileCodeService {
	
	@Autowired
	private MobileCodeMapper  mobileCodeMapper;

	@Override
	public void validateCode(String mobile, String code, String businessType) {
		Example example = new Example(MobileCode.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("mobile", mobile)
		        .andEqualTo("businessType",businessType)
		        .andEqualTo("code", code);
		//时间
		List<MobileCode> mobileCodeList = mobileCodeMapper.selectByExample(example);
		if(mobileCodeList==null || mobileCodeList.isEmpty()) {
			throw new ValidateCodeException("01","");
		}
		MobileCode mobileCode = mobileCodeList.get(0);
		
	}

}
