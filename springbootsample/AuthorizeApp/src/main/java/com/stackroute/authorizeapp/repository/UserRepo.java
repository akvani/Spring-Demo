package com.stackroute.authorizeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.authorizeapp.model.UserProfile;

@Repository
public interface UserRepo extends JpaRepository<UserProfile,String> {
	
	UserProfile findByEmailidAndPassword(String mail,String pass);

}
