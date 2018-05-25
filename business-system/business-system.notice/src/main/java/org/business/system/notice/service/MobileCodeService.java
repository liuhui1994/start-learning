package org.business.system.notice.service;

public interface MobileCodeService {
	
	public void validateCode(String mobile,String code,String businessType);

}
