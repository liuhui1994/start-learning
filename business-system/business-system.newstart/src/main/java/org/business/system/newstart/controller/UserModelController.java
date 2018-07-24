package org.business.system.newstart.controller;

import java.util.List;

import org.business.system.common.constants.SecurityConstants;
import org.business.system.common.em.UserState;
import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.business.system.common.util.AesUtil;
import org.business.system.newstart.em.ValidateType;
import org.business.system.newstart.service.UserModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserModelController {

	@Autowired
	private UserModelService  userModelService;
	
	
	@ApiOperation(value="获取用户详情", notes="根据用户的唯一id来获取用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户唯一ID", required = true, dataType = "Long",paramType = "path"),
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseMessage<UserModelDto> putUser(@PathVariable(name="id") Long id) {
		UserModel userModel =  userModelService.queryById(id);
		UserModelDto userModelDto = new UserModelDto();
		if(userModel!=null) {
			BeanUtils.copyProperties(userModel,userModelDto);
			Long userId = userModel.getId();
			userModelDto.setId(null);
			userModelDto.setUserIdEnc(AesUtil.encrypt(String.valueOf(userId), SecurityConstants.USER_ID_SECRET_KEY));
		}
        return ResponseMessage.success(userModelDto);
    }
	
	
	
	@ApiOperation(value="通过手机号获取用户详情", notes="根据用户的唯一手机号来获取用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "图书ID", required = true, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="/detailByMobile", method= RequestMethod.GET)
    public  ResponseMessage<UserModelDto> detailByMobile(@RequestParam(name="mobile") String  mobile) { 
		UserModel userModel = userModelService.getUserByMobile(mobile);
		UserModelDto userModelDto = new UserModelDto();
		if(userModel!=null) {
			BeanUtils.copyProperties(userModel,userModelDto);
			Long userId = userModel.getId();
			userModelDto.setId(null);
			userModelDto.setUserIdEnc(AesUtil.encrypt(String.valueOf(userId), SecurityConstants.USER_ID_SECRET_KEY));
		}
        return ResponseMessage.success(userModelDto);
    }
	
	
	@ApiOperation(value="通过登录名获取用户详情", notes="根据用户的唯一登录名来获取用户信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "图书ID", required = true, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value="/detailByLoginName", method= RequestMethod.GET)
    public ResponseMessage<UserModelDto> detailByLoginName(@RequestParam(name="loginName") String  loignName) { 
		UserModel userModel = userModelService.getUserByLoginName(loignName);
		UserModelDto userModelDto = new UserModelDto();
		if(userModel!=null) {
			BeanUtils.copyProperties(userModel,userModelDto);
			Long userId = userModel.getId();
			userModelDto.setId(null);
			userModelDto.setUserIdEnc(AesUtil.encrypt(String.valueOf(userId), SecurityConstants.USER_ID_SECRET_KEY));
		}
        return ResponseMessage.success(userModelDto);
    }
	
	@ApiOperation(value="获取用户列表", notes="获取用户列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userSelect", value = "用户查询对象", required = false, dataType = "UserModel"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value="/list", method= RequestMethod.POST)
    public ResponseMessage<PageInfo<UserModel>> list(
    		@RequestBody UserModel userSelect,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="create_date") String orderBy){ 
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<UserModel> userList = userModelService.getUserList(userSelect);
		PageInfo<UserModel> pageInfo = new PageInfo<UserModel>(userList);
        return ResponseMessage.success(pageInfo);
    }
	
    @RequestMapping(value="/register",method=RequestMethod.POST)
	@ApiOperation(value="用户注册", notes="用户注册" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "UserModelDto")
    })
   public ResponseMessage<UserModel> register(
	  		@RequestBody UserModelDto  user) {
		   return ResponseMessage.success(userModelService.register(user));
   }
    
    @RequestMapping(value="/openOrFreez",method=RequestMethod.POST)
	@ApiOperation(value="用户冻结或解冻", notes="用户冻结或解冻" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "用户对象", required = true, dataType = "UserState",paramType="query"),
            @ApiImplicitParam(name = "userIdEnc", value = "用户唯一标识", required = true, dataType = "String",paramType="query")
    })
   public ResponseMessage<UserModel> userOpenOrFreez(
		    @RequestParam(name="userIdEnc") String userIdEnc,
	  		@RequestParam(name="state") UserState state) {
		   return ResponseMessage.success(userModelService.openOrFreez(userIdEnc, state));
   }
    
    
    @RequestMapping(value="/resetPaypassword",method=RequestMethod.POST)
	@ApiOperation(value="用户重置支付密码", notes="用户重置支付密码" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIdEnc", value = "用户唯一标识", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "validateType", value = "校验类型", required = true, dataType = "ValidateType",paramType="query"),
            @ApiImplicitParam(name = "code", value = "手机验证码",  dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "oldPaypassword", value = "旧支付密码", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "newPaypassword1", value = "新支付密码1",required = true,dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "newPaypassword2", value = "新支付密码2",required = true,dataType = "String",paramType="query")
    })
   public ResponseMessage<UserModel> resetPaypassword(
		    @RequestParam(name="userIdEnc") String userIdEnc,
	  		@RequestParam(name="validateType") ValidateType validateType,
	  		@RequestParam(name="code") String code,
	  		@RequestParam(name="oldPaypassword") String oldPaypassword,
	  		@RequestParam(name="newPaypassword1") String newPaypassword1,
	  		@RequestParam(name="newPaypassword2") String newPaypassword2) {
		   return ResponseMessage.success();
   }
}
