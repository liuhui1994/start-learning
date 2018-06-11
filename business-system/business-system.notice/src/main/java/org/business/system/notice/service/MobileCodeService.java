package org.business.system.notice.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.em.BusinessType;
import org.business.system.notice.model.MobileCode;

public interface MobileCodeService extends BaseService<MobileCode, Long>{
	
	/**
	 * 验证短信验证码
	 * @param mobile
	 * @param code
	 * @param businessType
	 */
	public void validateCode(String mobile,String code,BusinessType businessType);
	
	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 */
	public int sendCode(String mobile,BusinessType businessType);

}
