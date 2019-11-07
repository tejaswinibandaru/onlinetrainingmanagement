package com.cg.onlinetraining.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetraining.dto.Chapter;
import com.cg.onlinetraining.dto.Course;
import com.cg.onlinetraining.exception.OTMSException;
import com.cg.onlinetraining.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ChapterService chapterService;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Override
	public Course addCourse(Course course) throws OTMSException {
		// TODO Auto-generated method stub
		if(course==null) {
			throw new OTMSException("Course found to be null");
		}
		if(courseRepository.existsByCourseName(course.getCourseName())) {
			throw new OTMSException("Course Already Exists");
		}
		course.setEnrolledDate(LocalDate.now());
		course.setChapterList(course.getChapterList());
		course.setDeleteFlag(0);
		course.setRegisterFlag(0);
		logger.info("Adding the course...");
		courseRepository.save(course);
		logger.info("Course added: "+course.getCourseName());
		return course;
	}

	@Override
	public Integer removeCourse(Long courseId) throws OTMSException {
		// TODO Auto-generated method stub
		Course course=courseRepository.findById(courseId).get();
		if(course==null) {
			throw new OTMSException("Course not found");
		}
		logger.info("Deleting the course...");
		course.setDeleteFlag(1);
		for(Chapter chapter:course.getChapterList()) {
			chapterService.removeChapter(chapter.getChapterId());
		}
		courseRepository.save(course);
		logger.info("Deleted the course...");
		return 1;
	}

	@Override
	public Course viewCourseById(Long courseId) throws OTMSException {
		// TODO Auto-generated method stub
		Course course=courseRepository.findById(courseId).get();
		if(course==null) {
			throw new OTMSException("Course not found...");
		}
		logger.info("Fetching the data...");
		return course;
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		logger.info("Listing all the courses...");
		return courseRepository.findAll();
	}

	@Override
	public List<Course> viewCourseByCategory(String category) throws OTMSException {
		// TODO Auto-generated method stub
		if(category==null) {
			throw new OTMSException("Category is empty");
		}
		List<Course> courses=courseRepository.findByCategory(category);
		if(courses.isEmpty()) {
			throw new OTMSException("No courses with category "+category+" found");
		}
		logger.info("Listing the courses by category...");
		return courses;
	}

	@Override
	public List<Course> viewCourseByRegisterFlag(Integer registerFlag) {
		// TODO Auto-generated method stub
		return courseRepository.findByRegisterFlag(1);
	}

	@Override
	public List<String> getAllCategories() {
		// TODO Auto-generated method stub
		return courseRepository.findAllCategories();
	}

	@Override
	public Course registerCourse(Long courseId) throws OTMSException {
		// TODO Auto-generated method stub
		Course course=courseRepository.findById(courseId).get();
		if(course==null) {
			throw new OTMSException("No course found");
		}
		course.setRegisterFlag(1);
		return course;
	}

}
