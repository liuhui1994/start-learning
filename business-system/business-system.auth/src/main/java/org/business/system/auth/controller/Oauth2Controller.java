package org.business.system.auth.controller;

import java.io.IOException;

import org.business.system.auth.comfiguration.User;
import org.business.system.auth.util.AuthServiceUtil;
import org.business.system.auth.util.Oauth2ResponseToken;
import org.business.system.common.model.UserModel;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"outh","notice"})
public class Oauth2Controller {
	@Autowired
	private ResourceServerTokenServices resourceServerTokenServices;
	
	
	@Value("${auth.url}")
	private String auth_url;
	
	@ApiOperation(value="通过token认证获取用户信息", notes="通过token认证获取用户信息" ,tags= {"outh"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "query"),
    })
	@RequestMapping(value="/getUserBytoken",method=RequestMethod.GET)
	public ResponseMessage<UserModel> token(@RequestParam(name="token")String token) {
//		String token = request.getParameter("access_token");
//		//CheckTokenEndpoint  ResourceServerTokenServices
////		System.out.println(resourceServerTokenServices.readAccessToken(token));
		OAuth2Authentication oAuth2Authentication = resourceServerTokenServices.loadAuthentication(token);
		User user = (User) oAuth2Authentication.getPrincipal();
		return ResponseMessage.success(user.getUserModel());
	}
	
	
	@ApiOperation(value="用户登录", notes="用户登录" ,tags= {"outh"})
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "图书ID", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "query")
    })
	@RequestMapping(value="/ssoLogin",method=RequestMethod.POST)
	public ResponseMessage<Oauth2ResponseToken> ssoLogin(
			@RequestParam(name="userName" ,required = true) String userName,
			@RequestParam(name="password" ,required = true) String password) throws JsonParseException, JsonMappingException, IOException{
        String  json = AuthServiceUtil.doPost(auth_url, userName, password);
        Oauth2ResponseToken token  = new ObjectMapper().readValue(json, Oauth2ResponseToken.class);
		return ResponseMessage.success(token);
	}
	

}
