package com.stackroute.hsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.hsample.dao.BookDAO;
import com.stackroute.hsample.model.Book;

 
@Controller
public class BookController {
	
	@Autowired
	BookDAO bookdao;
	

	@GetMapping("/")
	 public String gethome(ModelMap mymap)
	 {
      List<Book> books=bookdao.viewallbooks();
		
		mymap.put("books",books);
		return "index";
		
	 }
	
	@RequestMapping("/addbook")
	public ModelAndView addbook(@ModelAttribute("bookobj") Book bobj)
	{
		ModelAndView mviewobj=new ModelAndView("index");
		mviewobj.addObject("data","mary");
		
		
		//bookdao.addBook(bobj);
		return mviewobj;
		
		
	}
	
  @RequestMapping("/deletebook")
  public String deletebook(@RequestParam("qryid") String bid)
  {
	  
	  bookdao.deleteBook(bid);
	  return "redirect:/";
	  
  }
  
  @RequestMapping("/viewbook")
  public String viewbook(@RequestParam("qryid") String bid,ModelMap mymap)
  {
	
	  Book book=bookdao.findBookById(bid);
	  mymap.put("bookresult",book);
	
	  List<Book> books=bookdao.viewallbooks();
		
			mymap.put("books",books);
	  
			return "index";
  }
  
  @RequestMapping("/updatebook")
  public String updatebook(@ModelAttribute("bookmodi") Book bmodi)
  {
	  
	  bookdao.updateBook(bmodi);
	  
	  return "redirect:/";
  }
  

}
