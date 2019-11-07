package com.cg.onlinetraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.onlinetraining.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	public Course findByCourseName(String courseName);
	public Boolean existsByCourseName(String courseName);
	public List<Course> findByCategory(String category);
	public List<Course> findByRegisterFlag(Integer registerFlag);
	@Query("SELECT DISTINCT(course.category) FROM Course course")
	public List<String> findAllCategories();
}
