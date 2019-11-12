package com.cg.onlinetraining.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetraining.config.JwtProvider;
import com.cg.onlinetraining.dto.JwtResponse;
import com.cg.onlinetraining.dto.RegisterUserForm;
import com.cg.onlinetraining.dto.ResponseMessage;
import com.cg.onlinetraining.dto.User;
import com.cg.onlinetraining.dto.UserLoginForm;
import com.cg.onlinetraining.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/auth")
public class JwtAuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	HttpSession session;	
	
	@PostMapping("/login")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginForm loginRequest) {
	 
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	 
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	 
	    String jwt = jwtProvider.generateJwtToken(authentication);
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	 
	    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	  }
	
	@PostMapping("/register")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserForm signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    // Creating user's account
	    User user = new User(signUpRequest.getUsername(),encoder.encode(signUpRequest.getUserPassword()),signUpRequest.getEmail(),signUpRequest.getPhoneNumber(),signUpRequest.getDeleteFlag(),signUpRequest.getCourseList(),signUpRequest.getRole(),signUpRequest.isActive());
	    userRepository.save(user);
	 
	    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	  }
}
