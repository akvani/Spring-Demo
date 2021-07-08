package com.stackroute.hsample.dao;

import java.util.List;

import com.stackroute.hsample.model.Book;

 

public interface BookDAO {

	   void addBook(Book bookobj);
	   List<Book> viewallbooks();
	   Book findBookById(String bookid);
	   boolean deleteBook(String bookid);
	   
	   boolean updateBook(Book booknew);
	   
	   
	
}
