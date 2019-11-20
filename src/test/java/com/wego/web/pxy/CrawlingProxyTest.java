package com.wego.web.pxy;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wego.web.ctx.RootConfig;
import com.wego.web.ctx.ServletConfig;
import com.wego.web.ctx.WebConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServletConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class CrawlingProxyTest {
	@Autowired
	CrawlingProxy crawler;
	@Test
	public void testEngCrawling() {
		assertThat(crawler.engCrawling("https://endic.naver.com/?sLn=kr").size(), is(not(0)));
	}

	@Ignore
	public void testCgvCrawl() {
		fail("Not yet implemented");
	}

}