package com.stackroute.bookmvcapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
//@Repository
//@Transactional

public class BookDAOImpl {//implements BookDAO {

//	@Autowired
//	SessionFactory sessfactory;
//	
//	
//	public void addBook(Book bookobj) {
//		
//		sessfactory.getCurrentSession().save(bookobj);
//		
//		
//	}
//
//	public List<Book> viewallbooks() {
//
//List<Book> books=sessfactory.getCurrentSession().createQuery("from Book").list();
//		
//		return books;
//	}
//
//	public Book findBookById(String bookid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean deleteBook(String bookid) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean updateBook(Book booknew) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
