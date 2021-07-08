package com.stackroute.bookmvcapp.dao;

import java.util.List;

import com.stackroute.bookmvcapp.model.Book;

public interface BookDAO {

	   void addBook(Book bookobj);
	   List<Book> viewallbooks();
	   Book findBookById(String bookid);
	   boolean deleteBook(String bookid);
	   
	   boolean updateBook(Book booknew);
	   
	   
	
}
