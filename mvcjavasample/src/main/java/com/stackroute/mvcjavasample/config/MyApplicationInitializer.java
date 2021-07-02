package com.stackroute.mvcjavasample.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[] {MyDispatcherServlet.class};
	
	}

	@Override
	protected String[] getServletMappings() {
	 
		return new String[] {"/"};
	}

}
