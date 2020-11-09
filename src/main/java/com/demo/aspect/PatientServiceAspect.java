package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PatientServiceAspect {
	
	Logger logger = LoggerFactory.getLogger(PatientServiceAspect.class);

	@Before(value="execution (* com.demo.service.PatientService.*(..))")
	public void beforePatientSevice(JoinPoint joinPoint) {
		logger.info("beforePatientSevice---"+joinPoint.getSignature().getName());
	}
	
	@After(value="execution  (* com.demo.service.PatientService.*(..))")
	public void afterPatientSevice(JoinPoint joinPoint) {
		logger.info("afterPatientSevice---"+joinPoint.getSignature().getName());
	}

}
