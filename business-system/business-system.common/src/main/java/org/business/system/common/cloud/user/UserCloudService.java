package org.business.system.common.cloud.user;

import org.business.system.common.model.UserModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="newstart-service",name="newstart-service",path="/newstart")
public interface UserCloudService {
	
	@RequestMapping(value="/user/detail",method = RequestMethod.GET)
	public UserModel getUserByMobile(@RequestParam("mobile") String mobile);
	

}
