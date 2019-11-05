package com.cg.onlinetraining.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component("user")
@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	@JsonIgnore
	private String userPassword;
	@Column(name = "user_email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@Column(name = "courses")
	private List<Course> courseList;
	@Column(name = "delete_flag")
	private String deleteFlag;
	@Column(name = "role")
	private String role;
	@Column(name = "active_status")
	private Boolean active;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String username, String userPassword, String email, String phoneNumber, String deleteFlag,
			String role, Boolean active) {
		super();
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deleteFlag = deleteFlag;
		this.role = role;
		this.active = active;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
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

	@Override
	public int hashCode() {
		return this.userId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userPassword=" + userPassword + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", deleteFlag=" + deleteFlag + ", role=" + role + ", active="
				+ active + "]";
	}
	
	

}
