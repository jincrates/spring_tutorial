package org.zerock.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes = { org.zerock.config.RootConfig.class })
public class SampleServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Ignore
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info(service.doAdd("123", "456"));
	}
}
