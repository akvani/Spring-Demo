package com.stackroute.universityapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.universityapp.exception.UniversityAlreadyExistException;
import com.stackroute.universityapp.model.University;
import com.stackroute.universityapp.service.UniversityService;

@SpringBootTest
public class UniversityControllerTest {
	
	MockMvc mockmvc;
	
	@InjectMocks
	UniversityController unicontroller;
	
	@MockBean
	UniversityService uniservice;
	
	
	University universe;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setall()
	{
		MockitoAnnotations.initMocks(this);
		mockmvc=MockMvcBuilders.standaloneSetup(unicontroller).build();
	    universe =new University();
	    universe.setUniversityid("888");
	    universe.setUniversityname("Anna university");
			
	}
	
	
	@Test
	public void whenaddthenstoreuniversitysuccess() throws Exception
	{
	Mockito.when(uniservice.addUniversity(universe)).thenReturn(universe);
	
	mockmvc.perform(MockMvcRequestBuilders.post("/university/addUniversity")
											.contentType(MediaType.APPLICATION_JSON)
											.content(convertobject(universe)))
											.andExpect(MockMvcResultMatchers.status().isOk())
											.andDo(MockMvcResultHandlers.print());
											
		
	}
	
	public String convertobject(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
		String result=objmap.writeValueAsString(obj);
		return result;
		
	}
	

}
