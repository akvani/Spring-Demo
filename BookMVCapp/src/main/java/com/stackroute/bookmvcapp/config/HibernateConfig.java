package com.stackroute.bookmvcapp.config;

 

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.bookmvcapp.model.Book;

@Configuration
@EnableTransactionManagement

public class HibernateConfig {

	
	@Bean
	public DataSource getdatasource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/ibmdigital2");
		datasource.setUsername("root");
		datasource.setPassword("password");
		return datasource;
		
	}
	
	@Bean
	
	public LocalSessionFactoryBean getsessionfactory(DataSource ds) throws Exception
	{
		
		LocalSessionFactoryBean sessfact=new LocalSessionFactoryBean();
	  sessfact.setDataSource(ds);
	  Properties hiberprop=new Properties();
	  hiberprop.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
	  hiberprop.put("hibernate.show_sql","true");
	  hiberprop.put("hibernate.hbm2ddl.auto","update");
	  sessfact.setHibernateProperties(hiberprop);
    
	  sessfact.setAnnotatedClasses(Book.class);
	  
	  sessfact.afterPropertiesSet();
		
	  return sessfact;
	  
	
	}
	
	@Bean
	
	public HibernateTransactionManager gettransac(SessionFactory sess)
	{
		
		HibernateTransactionManager hmanager=new HibernateTransactionManager();
		
		hmanager.setSessionFactory(sess);
		
		return hmanager;
	}
	
}
