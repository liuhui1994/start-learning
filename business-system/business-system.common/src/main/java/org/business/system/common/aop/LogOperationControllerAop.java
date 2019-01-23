package org.business.system.common.aop;

import java.util.Date;

import javax.inject.Qualifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.business.system.common.annoation.SystemOperator;
import org.business.system.common.base.model.SystemLog;
import org.business.system.common.base.service.BaseService;
import org.business.system.common.mapper.SystemLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 操作记录
 * @author Administrator
 *
 */
@Aspect
@Component
public class LogOperationControllerAop {
	
	 /***
     * 定义service切入点拦截规则，拦截SystemServiceLog注解的方法
     */
//    @Pointcut("@annotation(com.vesus.springbootlog.annotation.SystemServiceLog)")
//    public void serviceAspect(){}
//
//    /***
//     * 定义controller切入点拦截规则，拦截SystemControllerLog注解的方法
//     */
//    @Pointcut("@annotation(com.vesus.springbootlog.annotation.SystemControllerLog)")
//    public void controllerAspect(){}
	
	@Autowired
	private ObjectMapper objmapper;
	
	
	@Autowired
    private SystemLogMapper systemLogMapper;
	


	


	
//	SystemOperator SystemOperator  变量 名必须大写   
//	@Around("execution(org.business.system.merchant.controller..*.*(..))")
	@Before("@annotation(SystemOperator)")
    public Object aroundInvoke(JoinPoint joinPoint,SystemOperator SystemOperator) 
            throws Throwable {

       Object object = joinPoint.getArgs();

       String  param = objmapper.writeValueAsString(object);
       
       SystemLog systemLog = new SystemLog();
       
       systemLog.setCreateDate(new Date());
       systemLog.setDescription(SystemOperator.descrption());
       systemLog.setOpType(SystemOperator.opType());
       systemLog.setParam(param);
       systemLog.setUserName("");
       systemLog.setUserType("");
       systemLogMapper.insertUseGeneratedKeys(systemLog);
       return "1";


    }

}
