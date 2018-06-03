package org.business.system.newstart.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.UserModel;

public interface UserModelService extends BaseService<UserModel, Long> {
	
	/**
	 * 根据手机号获取用户信息
	 * @param mobile
	 * @return
	 */
	public UserModel getUserByMobile(String mobile);

}
