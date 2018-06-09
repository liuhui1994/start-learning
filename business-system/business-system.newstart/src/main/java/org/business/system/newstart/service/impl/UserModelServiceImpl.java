package org.business.system.newstart.service.impl;

import java.util.List;

import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.model.UserModel;
import org.business.system.newstart.mapper.UserModelMapper;
import org.business.system.newstart.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserModelServiceImpl extends BaseServiceImpl<UserModel, Long> implements UserModelService{
	
	@Autowired
	private UserModelMapper userModelMapper;

	@Override
	public UserModel getUserByMobile(String mobile) {
		if(true){
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

}
