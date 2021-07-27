package com.stackroute.universityapp.repository;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.universityapp.model.University;

import junit.framework.Assert;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//
//public class UniversityRepositoryTest {
//	
//	
//	@Autowired
//	UniversityRepo repo;
//	
//	University universe;
//	
//	
//	@Before
//	public void setup()
//	{
//		universe =new University();
//	    universe.setUniversityid("888");
//	    universe.setUniversityname("Anna university");
//			
//	}
//	
//
//	@Test
//	public void adduniversity()
//	{
//		repo.save(universe);
//	Optional<University> uobj=repo.findById("888");
//	
//	Assert.assertEquals("Anna university" , uobj.get().getUniversityname());
//	
//		
//	}
//}
