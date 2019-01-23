package org.business.system.auth.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.business.system.auth.comfiguration.User;
import org.business.system.auth.util.AuthServiceUtil;
import org.business.system.auth.util.Oauth2ResponseToken;
import org.business.system.common.cloud.user.UserCloudService;
import org.business.system.common.em.UserType;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.business.system.common.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private UserCloudService  userCloudService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@Value("${auth.url}")
	private String auth_url;
	
	@ApiOperation(value="通过token认证获取用户信息", notes="通过token认证获取用户信息" ,tags= {"outh"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String",paramType = "query"),
    })
	@RequestMapping(value="/getUserBytoken",method=RequestMethod.GET)
	public ResponseMessage<UserModelDto> token() throws IOException {
		String token = request.getParameter("token");
		if(ObjectUtils.isEmpty(token)) {
			ResponseMessage.error("00", "未授权");
		}
//		//CheckTokenEndpoint  ResourceServerTokenServices
//		System.out.println(resourceServerTokenServices.readAccessToken(token));
		Map<String, Object> map = resourceServerTokenServices.readAccessToken(token).getAdditionalInformation();
//		userCloudService.getUserByMobile("17621875348");
//		System.out.println(map.get("user"));
//		System.out.println(map.get("user").toString());
		String json = new ObjectMapper().writeValueAsString(map.get("user"));
        User user  = new ObjectMapper().readValue(json, User.class);


//		OAuth2Authentication oAuth2Authentication = resourceServerTokenServices.loadAuthentication(token);
//		User user = (User) oAuth2Authentication.getPrincipal();
		return ResponseMessage.success(user.getUserModel());
        
//        return userCloudService.getUserByMobile("17621875348");
	}
	
	@CrossOrigin
	@ApiOperation(value="用户登录", notes="用户登录" ,tags= {"outh"})
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "图书ID", required = true, dataType = "String",paramType = "header"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "query")
    })
	@RequestMapping(value="/ssoLogin",method=RequestMethod.POST)
	public ResponseMessage<Oauth2ResponseToken> ssoLogin(
			@RequestParam(name="userName" ,required = true) String userName,
			@RequestParam(name="password" ,required = true) String password,
			@RequestParam(name="userType",required = true) UserType userType) throws IOException{
        String  json = AuthServiceUtil.doPost(auth_url, userName, Md5.encode(password));
        Oauth2ResponseToken token  = new ObjectMapper().readValue(json, Oauth2ResponseToken.class);
		return ResponseMessage.success(token);
	}
	

}
