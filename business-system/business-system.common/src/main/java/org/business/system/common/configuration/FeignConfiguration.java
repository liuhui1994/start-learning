package org.business.system.common.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 服务调用token传递
 * @author Administrator
 *
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public void apply(RequestTemplate arg0) {
		arg0.query("token", request.getParameter("token"));
	}
	

}
