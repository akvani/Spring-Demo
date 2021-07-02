package com.stackroute.clientapp.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.stackroute.clientapp.model.Client;

public class ClientRepository {
	
	ArrayList<Client> clients;
	
	public ClientRepository()
	{
		clients=new ArrayList<Client>();
	}
	
	
	public boolean addClient(Client clientnew)
	{
		clients.add(clientnew);
		return true;
		
	}
	
	public 	List<Client> viewClient()
	{
		return clients;
	}
	
	
	public  boolean deleteClient(String clientid)
	
	
	{
		
		
		//clients.removeIf( c-> c.getClientid().equals(clientid));
		
		 
		Iterator<Client> listit=clients.iterator();
		
		while(listit.hasNext())
		{
			Client clicurrent=listit.next();
			if(clicurrent.getClientid().equals(clientid))
			{
				listit.remove();
				return true;
			}
			     
		}
		return false;
		
	}
	
	
	public Client findclientByid(String id)
	{
	
		 Optional<Client> clientresult=  clients.stream().filter( cli->cli.getClientid().equals(id)).findAny();
		 
		 if(clientresult.isPresent())
		  return clientresult.get()	;
		 
		 else
			 
			 return null;
		 
	}
	
   public boolean updateClient(Client clientupd)
   {
	   
		 
			Iterator<Client> listit=clients.iterator();
			
			while(listit.hasNext())
			{
				Client clicurrent=listit.next();
				if(clicurrent.getClientid().equals(clientupd.getClientid()))
				{
					clicurrent.setClientname(clientupd.getClientname());
					clicurrent.setLocation(clientupd.getLocation());
					 
					return true;
				}
				     
			}
	   
	   
	   return false;
   }
	
}
