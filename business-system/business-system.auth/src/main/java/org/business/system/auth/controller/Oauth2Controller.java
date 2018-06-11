package org.business.system.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.business.system.auth.comfiguration.User;
import org.business.system.common.cloud.auth.OauthCloudService;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
	@Autowired
	private ResourceServerTokenServices resourceServerTokenServices;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private OauthCloudService oauthCloudService;
	
	@RequestMapping("/token")
	public ResponseMessage<User> token() {
		String token = request.getParameter("access_token");
		//CheckTokenEndpoint  ResourceServerTokenServices
//		System.out.println(resourceServerTokenServices.readAccessToken(token));
		OAuth2Authentication oAuth2Authentication = resourceServerTokenServices.loadAuthentication(token);
		User user = (User) oAuth2Authentication.getPrincipal();
		return ResponseMessage.success(user);
	}
	
	
	
	@RequestMapping("/ssoLogin")
	public ResponseMessage<User> ssoLogin(
			@RequestParam(name="userName" ,required = true) String userName,
			@RequestParam(name="password" ,required = true) String password,
			@RequestParam(name="loginType",required = true) String loginType){
		return null;
		
	}
	
	@RequestMapping("/test")
	public ResponseMessage<User> ssoLogin(){
		System.out.println(oauthCloudService.getNoticeById(
//				"Basic  Y2xpZW50OmZ1Y2tzZWN1cml0eQ==",
				"password", "admin", "admin123"));
		return null;
	}

}
