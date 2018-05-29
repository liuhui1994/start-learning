package org.business.system.notice.service.impl;

import java.util.Date;
import java.util.List;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.notice.mapper.MobileCodeMapper;
import org.business.system.notice.model.MobileCode;
import org.business.system.notice.service.MobileCodeService;
import org.business.system.notice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class MobileCodeServiceImpl extends BaseServiceImpl<MobileCode, Long> implements MobileCodeService {
	
	@Autowired
	private MobileCodeMapper  mobileCodeMapper;
	
	@Autowired
	private SmsService smsService;
	
    
	@Override
	public void validateCode(String mobile, String code, String businessType) {
		if(false){
			throw new CommonErrorException("03","手机号不存在");	
		}
		Example example = new Example(MobileCode.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("mobile", mobile)
		        .andEqualTo("businessType",businessType)
		        .andEqualTo("code", code)
		        .andEqualTo("isValidate", "TRUE");
		//时间
		List<MobileCode> mobileCodeList = mobileCodeMapper.selectByExample(example);
		if(mobileCodeList==null || mobileCodeList.isEmpty()) {
			throw new CommonErrorException("01","验证码不存在");
		}
		MobileCode mobileCode = mobileCodeList.get(0);
		if(mobileCode.getExpireDate().getTime()<new Date().getTime()){
			throw new CommonErrorException("02","验证码已过期");
		}	
		//更新验证码的验证状态
		mobileCode.setModifyDate(new Date());
		mobileCode.setIsValidate("FALSE");
		mobileCodeMapper.updateByPrimaryKeySelective(mobileCode);
	}


	@Override
	@Transactional
	public int sendCode(String mobile, String businessType) {
		if(false){
			throw new CommonErrorException("03","手机号不存在");	
		}
		String code = String.valueOf((Math.random()*9+1)*100000);
		MobileCode mobileCode = new MobileCode();
		mobileCode.setBusinessType(businessType);
		mobileCode.setCode(code);
		Date date = new Date();
		
		mobileCode.setExpireDate(new Date(date.getTime()+60*60*1000));
		mobileCode.setIsValidate("TRUE");
		mobileCode.setMobile(mobile);
		
		mobileCode.setCreateDate(new Date());
		mobileCode.setCreator(mobile);
		mobileCode.setModifier(mobile);
		mobileCode.setModifyDate(new Date());
		mobileCode.setStatus(0);
		mobileCodeMapper.insertSelective(mobileCode);
		smsService.sendAuthCode(mobile, code);
		return 1;
	}

}
