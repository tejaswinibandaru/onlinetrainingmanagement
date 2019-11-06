package com.cg.onlinetraining.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetraining.dto.Chapter;
import com.cg.onlinetraining.dto.Course;
import com.cg.onlinetraining.dto.ResponseMessage;
import com.cg.onlinetraining.service.ChapterService;
import com.cg.onlinetraining.service.CourseService;

@RestController
@RequestMapping(value = "/onlinetraining")
@CrossOrigin(origins = "*")
public class OnlineTrainingController {
	private static final Logger logger = LoggerFactory.getLogger(OnlineTrainingController.class);
	
	@Autowired
	CourseService courseService;
	@Autowired
	ChapterService chapterService;
	
	@PostMapping(value = "/addcourse")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<?> addCourse(@ModelAttribute Course course) {
		try {
			courseService.addCourse(course);
		}catch (Exception e) {
			logger.error("Error occurred: "+e.getMessage());
			return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseMessage("Course Added Successfully"), HttpStatus.OK);
	}
	@PostMapping(value = "/addchapter")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<?> addChapter(@ModelAttribute Chapter chapter,@RequestParam(value = "courseId")Long courseId){
		try {
			chapter.setCourse(courseService.viewCourseById(courseId));
			chapter.setDeleteFlag(0);
			chapter.setBookmarkFlag(0);
			chapterService.addChapter(chapter);
		}catch (Exception e) {
			logger.error("Error occurred: "+e.getMessage());
			return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new ResponseMessage("Chapter Added Successfully"), HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewallcourses")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<?> viewAllCourses(){
		List<Course> courses=courseService.viewAllCourses();
		logger.info("Viewing the list of all courses");
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewallchapters")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<?> viewAllChapters(@RequestParam(value = "courseId") Long courseId){
		List<Chapter> chapters;
		try {
			chapters=chapterService.viewAllChapters(courseService.viewCourseById(courseId));
		}catch (Exception e) {
			logger.error("Error occurred: "+e.getMessage());
			return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(chapters, HttpStatus.OK);
	}
}
