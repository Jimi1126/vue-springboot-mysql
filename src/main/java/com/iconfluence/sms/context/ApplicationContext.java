package com.iconfluence.sms.context;

import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationContext {

	private static ConfigurableApplicationContext cac = null;
	
	public static void initialize( ConfigurableApplicationContext cac ) {
		ApplicationContext.cac = cac;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return cac.getBean(clazz);
	}
	
}
