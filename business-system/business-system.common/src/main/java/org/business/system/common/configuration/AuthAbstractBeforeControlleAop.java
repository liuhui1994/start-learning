package org.business.system.common.configuration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.business.system.common.annoation.AuthAspectAnnoation;
import org.business.system.common.exception.CommonErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AuthAbstractBeforeControlleAop {
	
	@Autowired
	private HttpServletRequest request;
	
//	@Before("execution(* org.business.system.notice.controller..*.*(..))")
	@Before("@annotation(AuthAspectAnnoation)")
    public Object aroundInvoke(JoinPoint joinPoint,AuthAspectAnnoation AuthAspectAnnoation) 

            throws Throwable {
       System.out.println(request.getParameter("mobile"));
       System.out.println(1+"===========");

        Object object = joinPoint.getArgs();

       System.out.println(object+"");
       
       throw new CommonErrorException("00", "is have indivial access_token");


    }

}
