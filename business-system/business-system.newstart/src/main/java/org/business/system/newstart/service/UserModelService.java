package org.business.system.newstart.service;

import java.util.List;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.UserModel;

public interface UserModelService extends BaseService<UserModel, Long> {
	
	/**
	 * 根据手机号获取用户信息
	 * @param mobile
	 * @return
	 */
	public UserModel getUserByMobile(String mobile);
	
	/**
	 * 根据登录名获取用户信息
	 * @param mobile
	 * @return
	 */
	public UserModel getUserByLoginName(String loginName);
	
	/**
	 * 查询所有用户
	 * @param userModel
	 * @return
	 */
	public List<UserModel> getUserList(UserModel userModel);
	
	/**
	 * 新用户注册
	 * @param user
	 * @return
	 */
	public UserModel register(UserModel user);

}
