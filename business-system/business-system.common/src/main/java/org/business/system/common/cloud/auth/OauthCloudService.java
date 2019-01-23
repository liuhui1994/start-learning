package org.business.system.common.cloud.auth;

import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="auth-service",name="auth-service",path="/auth")
public interface OauthCloudService {
	
	  @RequestMapping(value="/getUserBytoken",method = RequestMethod.GET)
	  ResponseMessage<UserModelDto> getUserBytoken();
	  

	

}
