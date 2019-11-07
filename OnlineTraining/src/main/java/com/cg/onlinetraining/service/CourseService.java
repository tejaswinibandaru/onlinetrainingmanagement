package com.cg.onlinetraining.service;

import java.util.List;

import com.cg.onlinetraining.dto.Course;
import com.cg.onlinetraining.exception.OTMSException;

public interface CourseService {
	
	public Course addCourse(Course course)throws OTMSException;
	public Integer removeCourse(Long courseId) throws OTMSException;
	public Course viewCourseById(Long courseId) throws OTMSException;
	public List<Course> viewAllCourses();
	public List<Course> viewCourseByCategory(String category) throws OTMSException;
	public List<Course> viewCourseByRegisterFlag(Integer registerFlag);
	public List<String> getAllCategories();
	public Course registerCourse(Long courseId) throws OTMSException;
}
