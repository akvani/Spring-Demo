package com.org.FirstApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext appcontx=new ClassPathXmlApplicationContext("tuesbean.xml");
//        System.out.println( "Hello World!" );
   	
    	
        Employee emp= appcontx.getBean("empbean",Employee.class); // injecting bean
        
        //emp.getProject().setProjdescrip("CustomerCare Portal");
        emp.setEmpname("Dan");
        
      //  emp=null;
   //    System.out.println(emp.getEmpname());
        
       System.out.println("Belongs to Project " + emp.getProject().getProjdescrip());
//        System.out.println("---------------------------");
//        
//        Employee emp2=appcontx.getBean("empbean",Employee.class);
//        System.out.println("Second Employee");
//        System.out.println(emp2.getProject().getProjdescrip());
//        System.out.println(emp2.getEmpname());
//        
     
        
     //   System.out.println("Address is " + emp.getAddress().get("city"));
        
        
    }
}
