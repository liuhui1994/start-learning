package org.business.system.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
	@Autowired
	ResourceServerTokenServices resourceServerTokenServices;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/test")
	public String test() {
		String token = request.getParameter("access_token");
		//CheckTokenEndpoint  ResourceServerTokenServices
		System.out.println(resourceServerTokenServices.readAccessToken(token));
		System.out.println(resourceServerTokenServices.loadAuthentication(token).toString());
		return "HELLO WORLD";
	}

}
