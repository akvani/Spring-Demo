package com.stackroute.FirstJavaApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.stackroute.FirstJavaApp.Author;
import com.stackroute.FirstJavaApp.Book;

@Configuration

public class Myconfiguration {

	
	@Bean("bookbean")
	@Scope("singleton")
	public Book getBook()
	{
		
		Book book=new Book();
		book.setBookname("ASP");
		book.setBookid("100");
		return book;
	}
	
	
	@Bean("authorbean")
	public Author getAuthor()
	{
		Author author=new Author();
		author.setAuthorname("Robert V hook");
		return author;
	}
	
}
