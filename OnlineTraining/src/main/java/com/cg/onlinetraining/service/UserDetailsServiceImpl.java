package com.cg.onlinetraining.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.onlinetraining.dto.User;
import com.cg.onlinetraining.dto.UserDetailsImpl;
import com.cg.onlinetraining.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username : " + username));
		return UserDetailsImpl.build(user);
	}

}
