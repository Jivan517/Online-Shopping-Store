package cs544.project.onlineshoppingstore.service.aop;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import cs544.project.onlineshoppingstore.service.exception.CustomException;

import org.aspectj.lang.JoinPoint;

@Aspect
public class LogTraceAdvice {
	
	private Logger logger = Logger.getLogger(getClass());
	
	
	@Before("execution(public * cs544.project.onlineshoppingstore.controller.*(..))")
	public void beforeTrace(JoinPoint point){
		
		logger.log(Level.INFO, "requesting " + point.getSignature().getName());
	}
	
	@After("execution(public * cs544.project.onlineshoppingstore.controller.*(..))")
	public void afterTrace(JoinPoint point){
		
		logger.log(Level.INFO, "exiting " + point.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(public * cs544.project.onlineshoppingstore.controller.*(..))", throwing = "exception")
	public void beforeTrace(JoinPoint point, CustomException exception){
		
		logger.log(Level.INFO, "An exception occured while executing " + point.getSignature().getName());
		logger.log(Level.ERROR, "Exception Message: " + exception.getMessage() + " \nStackTrace: " +exception.getStackTrace() );
	}



}
