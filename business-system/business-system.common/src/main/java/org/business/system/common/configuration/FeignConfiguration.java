package org.business.system.common.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignConfiguration implements RequestInterceptor {
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public void apply(RequestTemplate arg0) {
		arg0.query("access_token", request.getParameter("token"));
	}
	

}
