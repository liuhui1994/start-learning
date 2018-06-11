package org.business.system.newstart.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.constants.GlobalConstants;
import org.business.system.common.constants.SecurityConstants;
import org.business.system.common.em.BooleanType;
import org.business.system.common.em.UserState;
import org.business.system.common.em.UserType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.UserModel;
import org.business.system.common.util.AesUtil;
import org.business.system.common.util.Md5;
import org.business.system.common.util.PatternUtils;
import org.business.system.newstart.mapper.UserModelMapper;
import org.business.system.newstart.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserModelServiceImpl extends BaseServiceImpl<UserModel, Long> implements UserModelService{
	
	@Autowired
	private UserModelMapper userModelMapper;
	
	@Autowired
	private HttpServletRequest request;
	
//	@Autowired
//	private AccountCloudService accountCloudService;

	@Override
	public UserModel getUserByMobile(String mobile) {
		if(!PatternUtils.validateMobile(mobile)){
			throw new CommonErrorException("00", "手机号不合法");
		}
		Example example = new Example(UserModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("phone", mobile);
		criteria.andEqualTo("status", BooleanType.FALSE);
        List<UserModel> userList = userModelMapper.selectByExample(example);
        if(userList==null || userList.isEmpty()){
        	return null;
        }
        return userList.get(0);
	}
	
	@Override
	public UserModel getUserByLoginName(String loginName) {
		Example example = new Example(UserModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("loginName", loginName);
		criteria.andEqualTo("status", BooleanType.FALSE);
        List<UserModel> userList = userModelMapper.selectByExample(example);
        if(userList==null || userList.isEmpty()){
        	return null;
        }
        return userList.get(0);
	}
	
	/**
	 * 生成查询的example
	 * @param userModel
	 * @return
	 */
	private Example createaExample(UserModel userModel){
		Example example = new Example(UserModel.class);
        Criteria criteria = example.createCriteria();
        if(!ObjectUtils.isEmpty(userModel.getPhone())){
        	criteria.andGreaterThanOrEqualTo("phone", userModel.getPhone());
        }
        if(userModel.getAppId()!=null && !"".equals(userModel.getAppId())){
        	criteria.andEqualTo("appId", userModel.getAppId());
        }
		criteria.andEqualTo("status", BooleanType.FALSE);
		return example;
	}


	@Override
	public List<UserModel> getUserList(UserModel userModel) {
        Example example = createaExample(userModel);
		return userModelMapper.selectByExample(example);
	}


	@Override
	@Transactional
	public UserModel register(UserModel user) {
        UserModel userModel = new UserModel();
        String mobile = user.getPhone();
        String loginName = user.getLoginName();
        String password = user.getPassword();
        String payAccount = user.getPayAccount();
        UserType userType = user.getUserType();
        String payPassword= user.getPayPassword();
        String nickName = user.getNickName();
        String username = user.getUsername();
        //查询该用户名是否存在
        if(!ObjectUtils.isEmpty(mobile)){
        	if(!PatternUtils.validateMobile(mobile)){
        		throw new CommonErrorException("01", "手机号不合法");
        	}
			if(getUserByMobile(mobile)!=null) {
				throw new CommonErrorException("02", "手机号已存在");	
			}	
			userModel.setPhone(mobile);
        }else{
        	throw new CommonErrorException("03", "手机号不能为空");
        }
        if(!ObjectUtils.isEmpty(loginName)){
			if(getUserByLoginName(loginName)!=null) {
				throw new CommonErrorException("04", "登录名已存在");					
			}
			userModel.setLoginName(loginName);
        }else{
        	userModel.setLoginName(mobile);
        }
        if(!ObjectUtils.isEmpty(payAccount)) {
        	userModel.setPayAccount(payAccount);
        }
        if(!ObjectUtils.isEmpty(payPassword)) {
        	userModel.setPayPassword(Md5.encode(payPassword));
        }
        if(!ObjectUtils.isEmpty(nickName)) {
        	userModel.setNickName(nickName);
        }
        if(!ObjectUtils.isEmpty(username)) {
        	userModel.setUsername(username);
        }
        if(!ObjectUtils.isEmpty(password)){
        	userModel.setPassword(Md5.encode(password));
        }else{
        	userModel.setPassword(Md5.encode(mobile));
        }
        if(ObjectUtils.isEmpty(payAccount)) {
        	userModel.setPayAccount(null);
        }
        if(ObjectUtils.isEmpty(userType) || userType.equals(UserType.SYSTEM)) {
        	userModel.setUserType(UserType.SYSTEM);
        }
                
        userModel.setRegisterIp(request.getRemoteAddr());
        userModel.setCreateDate(new Date());
        userModel.setModifyDate(new Date());
        userModel.setCreator("admin");
        userModel.setModifier("admin");
        userModel.setState(UserState.OPEN);
        userModel.setStatus(BooleanType.FALSE);
        
        userModel.setAppId(UUID.randomUUID().toString().replace("-", ""));
        userModel.setAppKey(UUID.randomUUID().toString().replace("-", ""));
        
        int success = userModelMapper.insertSelective(userModel);
        
        if(!ObjectUtils.isEmpty(userType) && !userType.equals(UserType.SYSTEM)) {
        	//非系统用户创建账户体系
        	
        	//注册奖励
        }
        
        if(success<=0){
        	throw new CommonErrorException(GlobalConstants.SERVICE_INVOKE_EXCEPTION_CODE,
        			GlobalConstants.SERVICE_EXCEPTION_MESSAGE);
        }
		return userModel;
	}
	

	@Override
	@Transactional
	public UserModel openOrFreez(String userIdEnc, UserState state) {
		Long userId = null;
		try {
			userId = Long.parseLong(AesUtil.decrypt(userIdEnc, SecurityConstants.USER_ID_SECRET_KEY));
		} catch (NumberFormatException e) {
			throw new CommonErrorException("06", "你输入的userIdEnc参数有误"); 
		}	
		UserModel userModel = userModelMapper.selectByPrimaryKey(userId);
		if(userModel==null) {
			throw new CommonErrorException("05", "用户不存在"); 
		}
		userModel.setState(state);
		userModel.setModifier("admin");
		userModel.setModifyDate(new Date());
		int success = userModelMapper.updateByPrimaryKeySelective(userModel);
		if(success<=0) {
        	throw new CommonErrorException(GlobalConstants.SERVICE_INVOKE_EXCEPTION_CODE,
        			GlobalConstants.SERVICE_EXCEPTION_MESSAGE);	
		}
		return userModel;
	}
	



}
