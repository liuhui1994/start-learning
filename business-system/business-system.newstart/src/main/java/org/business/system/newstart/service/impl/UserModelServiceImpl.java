package org.business.system.newstart.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.constants.GlobalConstants;
import org.business.system.common.em.UserState;
import org.business.system.common.em.UserType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.UserModel;
import org.business.system.common.util.Md5;
import org.business.system.common.util.PatternUtils;
import org.business.system.newstart.mapper.UserModelMapper;
import org.business.system.newstart.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserModelServiceImpl extends BaseServiceImpl<UserModel, Long> implements UserModelService{
	
	@Autowired
	private UserModelMapper userModelMapper;
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public UserModel getUserByMobile(String mobile) {
		if(!PatternUtils.validateMobile(mobile)){
			throw new CommonErrorException("00", "手机号不合法");
		}
		Example example = new Example(UserModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andCondition("phone", mobile);
        List<UserModel> userList = userModelMapper.selectByExample(criteria);
        if(userList==null && userList.isEmpty()){
        	throw new CommonErrorException("01", "用户不存在");
        }
        return userList.get(0);
	}
	
	@Override
	public UserModel getUserByLoginName(String loginName) {
		Example example = new Example(UserModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andCondition("loginName", loginName);
        List<UserModel> userList = userModelMapper.selectByExample(criteria);
        if(userList==null && userList.isEmpty()){
        	throw new CommonErrorException("01", "用户不存在");
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
		return example;
	}


	@Override
	public List<UserModel> getUserList(UserModel userModel) {
        Example example = createaExample(userModel);
		return userModelMapper.selectByExample(example);
	}


	@Override
	public UserModel register(UserModel user) {
        UserModel userModel = new UserModel();
        String mobile = userModel.getPhone();
        String loginName = userModel.getLoginName();
        String password = userModel.getPassword();
        String payAccount = userModel.getPayAccount();
        UserType userType = userModel.getUserType();
        String payPassword= userModel.getPayPassword();
        String nickName = userModel.getNickName();
        String userName = userModel.getUsername();
        //查询该用户名是否存在
        if(!ObjectUtils.isEmpty(mobile)){
        	if(!PatternUtils.validateMobile(mobile)){
        		throw new CommonErrorException("00", "手机号不合法");
        	}
        	userModel.setPhone(mobile);
        }else{
        	throw new CommonErrorException("01", "手机号不能为空");
        }
        if(!ObjectUtils.isEmpty(loginName)){
            getUserByLoginName(loginName);
            userModel.setUsername(loginName);
        }else{
        	userModel.setLoginName(mobile);
        }
        if(!ObjectUtils.isEmpty(password)){
        	userModel.setPassword(Md5.encode(password));
        }else{
        	userModel.setPassword(Md5.encode(mobile));
        }
                
        
        userModel.setRegisterIp("");
        userModel.setCreateDate(new Date());
        userModel.setModifyDate(new Date());
        userModel.setCreator("");
        userModel.setModifier("");
        userModel.setState(UserState.OPEN);
        
        userModel.setAppId(UUID.randomUUID().toString().replace("-", ""));
        userModel.setAppKey(UUID.randomUUID().toString().replace("-", ""));
        
        int success = userModelMapper.insertSelective(userModel);
        if(success<=0){
        	throw new CommonErrorException(GlobalConstants.SERVICE_INVOKE_EXCEPTION_CODE,
        			GlobalConstants.SERVICE_EXCEPTION_MESSAGE);
        }
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}



}
