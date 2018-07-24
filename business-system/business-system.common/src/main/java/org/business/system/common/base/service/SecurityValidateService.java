package org.business.system.common.base.service;

public interface SecurityValidateService {

	/**
	 * 通过userIdEnc 获取userId
	 * @param userIdEnc
	 * @return
	 */
	public Long  getUserIdByUserIdEnc(String userIdEnc);
}
