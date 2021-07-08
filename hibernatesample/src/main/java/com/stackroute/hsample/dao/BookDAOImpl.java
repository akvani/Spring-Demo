package com.stackroute.hsample.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.hsample.model.Book;

 
@Repository
@Transactional

public class BookDAOImpl implements BookDAO {

	@Autowired
	SessionFactory sessfactory;
	
	
	public void addBook(Book bookobj) {
		
		sessfactory.getCurrentSession().save(bookobj);
		
		
	}

	public List<Book> viewallbooks() {

List<Book> books=sessfactory.getCurrentSession().createQuery("from Book").list();
		
		return books;
	}

	public Book findBookById(String bookid) {
		
		
Optional<Book> bookopt=	sessfactory.getCurrentSession().createQuery("from Book where bookid='"+bookid+"'").uniqueResultOptional();

   if(bookopt.isPresent())
	   return bookopt.get();
   else
		return null;
   
	}

	public boolean deleteBook(String bid) {
		
		Book bookresult=findBookById(bid);
		
		if(bookresult==null)
			return false;

		sessfactory.getCurrentSession().delete(bookresult);
		return true;
	}

	public boolean updateBook(Book booknew) {
		
		Book bookres=findBookById(booknew.getBookid());
		
		if(bookres==null)
			return false;
		
	    	
		bookres.setBookname(booknew.getBookname());
		sessfactory.getCurrentSession().update(bookres);
		return true;
	}

}
