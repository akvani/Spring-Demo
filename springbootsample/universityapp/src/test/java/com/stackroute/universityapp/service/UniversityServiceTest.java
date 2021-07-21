package com.stackroute.universityapp.service;

//import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.universityapp.exception.UniversityAlreadyExistException;
import com.stackroute.universityapp.exception.UniversityNotFoundException;
import com.stackroute.universityapp.model.University;
import com.stackroute.universityapp.repository.UniversityRepo;

public class UniversityServiceTest {

	@InjectMocks
	UnivsersityServiceImpl uniservice;
	
	@Mock
	UniversityRepo unirepo;
  
	 University universe;
	 
	 @SuppressWarnings("deprecation")
		@BeforeEach
		public void setall()
		{
			MockitoAnnotations.initMocks(this);
			
		    universe =new University();
		    universe.setUniversityid("888");
		    universe.setUniversityname("Anna university");
				
		}
	
	 @Test
	 public void whencalladduniversitytobesaved() throws UniversityAlreadyExistException
	 {
		 Mockito.when(unirepo.save(universe)).thenReturn(universe);
		 
	University uniresult=uniservice.addUniversity(universe);
	
assertEquals(uniresult.getUniversityname(),"Anna university");
 Mockito.verify(unirepo, times(1)).save(any());
		 
	 }
	 
	 
	 @Test
	 public void whendeletinginvalididexpectexception()
	 {
		 Mockito.when(unirepo.getOne(any())).thenReturn(null);
		 
		 
		 Assertions.assertThrows(UniversityNotFoundException.class, ()->uniservice.deleteUniversity("sdf"));
		 
		 Mockito.verify(unirepo,times(1)).findById(any());
		 
	 }
	 
	 
}
