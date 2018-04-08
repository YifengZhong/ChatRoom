package com.Ilvcode.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
	
	 	@Pointcut("execution(* com.Ilvcode.controller..*(..))")
 	    public void forControllerPkg() {}
	 	
	 	@Pointcut("execution(* com.Ilvcode.dao..*(..))")
 	    public void forDaoPkg() {}
	 	
	 	@Pointcut("execution(* com.Ilvcode.service..*(..))")
 	    public void forServicePkg() {}

	    @Pointcut("@annotation(com.Ilvcode.aspect.annotation.Logging)")
	    public void logging() {}
	
		@Before("logging() || forControllerPkg() || forDaoPkg() || forServicePkg()")
		public void logResource(JoinPoint joinPoint) {
		    Logger log = Logger.getLogger("");
		    log.info("   **********     TARGET CLASS : " + 
		    			joinPoint.getSignature().getDeclaringTypeName() + "." +
		    			joinPoint.getSignature().getName() + 
		    			"    **********");
	  }
}
