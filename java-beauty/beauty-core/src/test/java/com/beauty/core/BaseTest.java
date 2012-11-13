package com.beauty.core;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wthe
 * @version date：Jul 27, 2012 2:09:05 PM description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
	final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	public BaseTest() {
		PropertyConfigurator.configure(BaseTest.class.getClassLoader().getResource("log4j.properties"));
	}

	@Rule
	public TestRule watchman = new TestWatcher() {
		protected void starting(Description description) {
			logger.info("{} being run...", description.getMethodName());
			super.starting(description);
		}

		protected void failed(Throwable e, Description description) {
			logger.error("{} throw {}", description.getMethodName(), e.getMessage());
			super.failed(e, description);
		}
	};

}
