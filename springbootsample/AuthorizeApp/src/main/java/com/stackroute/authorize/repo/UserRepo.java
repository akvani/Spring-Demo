package com.stackroute.authorize.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.authorize.model.Userprofile;

@Repository
public interface UserRepo extends JpaRepository<Userprofile,String> {
	
Userprofile	findByEmailidAndPassword(String email,String pwd);

}
