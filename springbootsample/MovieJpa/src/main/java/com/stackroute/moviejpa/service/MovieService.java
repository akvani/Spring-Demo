package com.stackroute.moviejpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.stackroute.moviejpa.model.Movie;
import com.stackroute.moviejpa.repository.MovieRepo;
 

@Service
public class MovieService {
	
	
	@Autowired
	MovieRepo mrepo;
	
	public Movie addMovie(Movie movobj)
	{
		mrepo.save(movobj);
		return movobj;
	}
	
	public List<Movie> getmovie()
	{
		return mrepo.findAll();
	}
	

}
