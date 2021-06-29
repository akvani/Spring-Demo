package com.stackroute.clientapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.clientapp.model.Client;
import com.stackroute.clientapp.repository.ClientRepository;

@Controller

public class ClientController {
	
	
	ApplicationContext appcontext=new ClassPathXmlApplicationContext("mybean.xml");
	ClientRepository clientrepo=appcontext.getBean("clientrepobean",ClientRepository.class);
	
	
	@GetMapping("/")
	public String gethomepage(ModelMap map)
	{
		
List<Client> clients=clientrepo.viewClient();
		
		map.put("clientarr",clients);
		
		return "index";
		
	 
	}
	
	
	@PostMapping("/addclient")
	
	public String addclient(@ModelAttribute("clientobj") Client clientnew,ModelMap map)
	{
		
	 
		clientrepo.addClient(clientnew);
	   return "redirect:/";	
		
		
	}
	
	
	
	
	
	@RequestMapping("/deleteclient")
	public String delclient(@RequestParam("qryid") String id,ModelMap map)
	{
		
		boolean result=clientrepo.deleteClient(id);

	 return "redirect:/";
	 
	}
	

	@GetMapping("/viewclient")
	public String viewclient(@RequestParam("qryid") String clientid,ModelMap map)
	{
		Client clientfound=clientrepo.findclientByid(clientid);
		
List<Client> clients=clientrepo.viewClient();
		
		map.put("clientarr",clients);
		map.put("clientfound",clientfound);
		
		return "index";
		
	}
	
	
	@RequestMapping("/update")
	public String modifyClient(@ModelAttribute("clientmodi") Client clienobj)
	
	{
		
		boolean ans=clientrepo.updateClient(clienobj);
		
		return "redirect:/";
		
	}
	
	
	
}
