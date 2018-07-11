package org.business.system.common.cloud.user;

import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="newstart-service",name="newstart-service",path="/newstart")
public interface UserCloudService {
	
	@RequestMapping(value="/user/detailByMobile",method = RequestMethod.GET)
	public ResponseMessage<UserModel> getUserByMobile(@RequestParam("mobile") String mobile);
	

	@RequestMapping(value="/user/detailByLoginName",method = RequestMethod.GET)
	public  ResponseMessage<UserModel> getUserByLoginName(@RequestParam("loginName") String loginName);
	
	@RequestMapping(value="/user/register",method = RequestMethod.POST)
	public  ResponseMessage<UserModel> register(@RequestBody UserModelDto  userModel);
}
