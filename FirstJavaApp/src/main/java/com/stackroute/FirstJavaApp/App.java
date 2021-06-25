package com.stackroute.FirstJavaApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.FirstJavaApp.config.Myconfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext appcontext=new AnnotationConfigApplicationContext(Myconfiguration.class);
        
        Book bookobj=appcontext.getBean("bookbean",Book.class);
        
        System.out.println(bookobj.bookname);
        System.out.println(bookobj.getAuthor().getAuthorname());
        
    }
}
