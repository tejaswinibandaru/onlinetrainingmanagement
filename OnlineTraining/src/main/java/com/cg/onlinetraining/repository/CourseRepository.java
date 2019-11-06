package com.cg.onlinetraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinetraining.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	public Course findByCourseName(String courseName);
	public Boolean existsByCourseName(String courseName);
	public List<Course> findByCategory(String category);
	public List<Course> findByRegisterFlag(Integer registerFlag);
}
