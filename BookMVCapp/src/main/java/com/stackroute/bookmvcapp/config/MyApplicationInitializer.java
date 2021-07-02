package com.stackroute.bookmvcapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {HibernateConfig.class};
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
