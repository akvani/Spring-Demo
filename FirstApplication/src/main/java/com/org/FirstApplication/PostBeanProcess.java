package com.org.FirstApplication;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostBeanProcess implements BeanPostProcessor {
	
	public Object postProcessBeforeInitialization(Object bobj,String name)
	{
		Project projbean;
		System.out.println("current bean in before  is " + name);
		
		if(name.equals("project"))
		{
			projbean=(Project)bobj;
			projbean.setProjdescrip("online mediclaim");
			return projbean;
		}
		return bobj;
	}
	
	public Object postProcessAfterInitialization(Object bobj,String name)
	{
		System.out.println("current bean in after process is " + name);
		
		return bobj;
	}

}
