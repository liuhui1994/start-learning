package org.business.system.common.aop;

import javax.servlet.http.HttpServletRequest;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.business.system.common.annoation.AuthAspectAnnoation;
import org.business.system.common.exception.CommonErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Aspect
@Component
public class AuthAbstractBeforeControlleAop {
	
	@Autowired
	private HttpServletRequest request;
	
//	@Before("execution(* org.business.system.notice.controller..*.*(..))")
	@Before("@annotation(AuthAspectAnnoation)")
    public Object aroundInvoke(JoinPoint joinPoint,AuthAspectAnnoation AuthAspectAnnoation) 

            throws Throwable {
       String access_token = request.getParameter("token");
       System.out.println(access_token+"===========");

        Object object = joinPoint.getArgs();

       System.out.println(object+"");
       if(ObjectUtils.isEmpty(access_token) || "null".equals(access_token)) {
    	   throw new CommonErrorException("00", "is have indivial access_token");

       }
       return  access_token;


    }
	
	

}
