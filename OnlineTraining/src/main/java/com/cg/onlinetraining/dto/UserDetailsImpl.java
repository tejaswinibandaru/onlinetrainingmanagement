package com.cg.onlinetraining.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 5489574544731744399L;
	
	private Long userId;
	private String username;
	@JsonIgnore
	private String userPassword;
	private String email;
	private String phoneNumber;
	private List<Course> courseList;
	private String deleteFlag;
	private String role;
	private Boolean active;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetailsImpl(Long userId, String username, String userPassword, String email, String phoneNumber,
			List<Course> courseList, String deleteFlag, String role, Boolean active,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.courseList = courseList;
		this.deleteFlag = deleteFlag;
		this.role = role;
		this.active = active;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getUserPassword(), user.getEmail(), user.getPhoneNumber(), user.getCourseList(), user.getDeleteFlag(), user.getRole(), user.getActive(), authorities);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

}
