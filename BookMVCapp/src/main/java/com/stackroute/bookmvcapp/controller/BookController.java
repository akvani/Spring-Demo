package com.stackroute.bookmvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.bookmvcapp.dao.BookDAO;
import com.stackroute.bookmvcapp.model.Book;

@Controller
public class BookController {
	
	@Autowired
	BookDAO bookdao;
	

	@GetMapping("/")
	 public String gethome()
	 {
		return "index"; 
		
	 }
	
//	@RequestMapping("/addbook")
//	public String addbook(@ModelAttribute Book bobj,ModelMap mymap)
//	{
//		bookdao.addBook(bobj);
//		List<Book> books=bookdao.viewallbooks();
//		
//		mymap.put("books",books);
//		return "index";
//	}
//	
//	

}
