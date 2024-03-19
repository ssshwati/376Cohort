package com.wileyedge.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Pointcut(value = "execution (* *.save*(..))")
	public void dummy() {
		
	}
//	@Before(value = "dummy()")
	public void logBefore(JoinPoint jp) {
		System.out.println("inside method "+jp.getSignature().getName());
	}
//	@AfterReturning(value = "dummy()",returning = "r")
	public void logAfter(JoinPoint jp,Object r) {
		System.out.println("exiting from "+jp.getSignature().getName());
	}
	@Around(value="dummy()")
	public Object logAround(ProceedingJoinPoint jp) {
		Object retObj = null;
		System.out.println("inside method "+jp.getSignature().getName());
		try {
			retObj=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting method "+jp.getSignature().getName());
		return retObj;
	}
}
