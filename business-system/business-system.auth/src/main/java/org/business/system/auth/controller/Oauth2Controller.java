package org.business.system.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.business.system.auth.comfiguration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
	@Autowired
	private ResourceServerTokenServices resourceServerTokenServices;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/token")
	public User token() {
		String token = request.getParameter("access_token");
		//CheckTokenEndpoint  ResourceServerTokenServices
//		System.out.println(resourceServerTokenServices.readAccessToken(token));
		OAuth2Authentication oAuth2Authentication = resourceServerTokenServices.loadAuthentication(token);
		User user = (User) oAuth2Authentication.getPrincipal();
		return user;
	}

}
