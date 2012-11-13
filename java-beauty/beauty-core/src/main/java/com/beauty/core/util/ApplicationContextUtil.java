package com.beauty.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {
	private final Logger logger = LoggerFactory.getLogger(ApplicationContextUtil.class);

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ContextUtils.setApplicationContext(applicationContext);
		logger.debug("ApplicationContext registed");
	}

}
