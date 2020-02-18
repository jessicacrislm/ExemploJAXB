package com.example.testejaxb.interceptors;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Interceptor
@Component
@Log
public class LogInterceptor {
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		String className = context.getTarget().getClass().getName();
		String methodName = context.getMethod().getName();
		//List<Parameter> paramList = Arrays.asList(context.getMethod().getParameters());
		//String reportName = paramList.stream().filter(p -> p.getName().equalsIgnoreCase("nomeRelatorio")).map(Parameter::toString).findFirst().orElse(StringUtils.EMPTY);
		String parameters = Arrays.toString(context.getMethod().getParameters());
		
		Logger log = LoggerFactory.getLogger(className);
		
		log.info(String.format(">>> {}.{}. [{}]", className, methodName, parameters));
		//log.info(reportName);
		long timeBefore = System.currentTimeMillis();
		
		try {
			return context.proceed();
		} finally {
			long timeAfter = System.currentTimeMillis();
			log.info(String.format("<<< {}.{}. [{}]", className, methodName, parameters));
			log.info(String.format("Relatorio {}.{} " + className + "." + methodName + " gerado em " + (timeAfter - timeBefore) + "ms."));
		}
		
	}
}
