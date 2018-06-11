package org.business.system.auth.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.business.system.auth.comfiguration.User;
import org.business.system.common.cloud.auth.OauthCloudService;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class Oauth2Controller {
	@Autowired
	private ResourceServerTokenServices resourceServerTokenServices;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private OauthCloudService oauthCloudService;
	
	@RequestMapping(value="/token",method=RequestMethod.GET)
	public ResponseMessage<User> token() {
		String token = request.getParameter("access_token");
		//CheckTokenEndpoint  ResourceServerTokenServices
//		System.out.println(resourceServerTokenServices.readAccessToken(token));
		OAuth2Authentication oAuth2Authentication = resourceServerTokenServices.loadAuthentication(token);
		User user = (User) oAuth2Authentication.getPrincipal();
		return ResponseMessage.success(user);
	}
	
	
	@ApiOperation(value="用户登录", notes="根据消息的唯一id来获取消息内容" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorize", value = "图书ID", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "query")
    })
	@RequestMapping(value="/ssoLogin",method=RequestMethod.POST)
	public ResponseMessage<User> ssoLogin(
		    Authentication principal,
			@RequestParam(name="userName" ,required = true) String userName,
			@RequestParam(name="password" ,required = true) String password){
//		Principal p = (Principal)principal.getPrincipal();
		Map<String, String> map =new HashMap<String, String>();
		principal=        SecurityContextHolder.getContext().getAuthentication();
		map.put("grant_type", "password");
		map.put("username", userName);
		map.put("password", password);
		System.out.println(oauthCloudService.getNoticeById(SecurityContextHolder.getContext().getAuthentication(), map));
		return null;
		
	}
	
	@RequestMapping("/test")
	public ResponseMessage<User> ssoLogin(Authentication principal){

		return null;
	}

}
