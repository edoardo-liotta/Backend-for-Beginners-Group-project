package com.mcs.be.course.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DebuggingLoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(DebuggingLoggingAspect.class);

    //TODO add a new method with a joint point definition to log at debug level response time in millis of a method execution

}


