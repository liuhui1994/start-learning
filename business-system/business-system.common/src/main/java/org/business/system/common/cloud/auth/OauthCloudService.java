package org.business.system.common.cloud.auth;

import org.business.system.common.model.Notice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="auth-service",name="auth-service",path="/auth")
public interface OauthCloudService {
	
	@RequestMapping(value="/auth/token",method = RequestMethod.POST)
	public Notice getNoticeById(
//			@RequestHeader String authorization,
			@RequestParam(name="grant_type") String grant_type,
			@RequestParam(name="username") String username,
			@RequestParam(name="password") String password);
	

}
