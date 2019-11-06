package com.cg.onlinetraining.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinetraining.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//Description:- find user by username and password
	public User findByUsernameAndUserPassword(String username,String password);
	//Description:-find user by username
	public Optional<User> findByUsername(String username);
	//Description:-checks whether user with username already exists
	public Boolean existsByUsername(String username);
	//Description:-checks whether user with email already exists
	public Boolean existsByEmail(String email);
}
