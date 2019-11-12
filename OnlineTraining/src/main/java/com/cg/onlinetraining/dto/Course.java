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

@Component("course")
@Entity
@Table(name="course_details")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long courseId;
	@Column(name = "course_name")
	private String courseName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
	private List<Chapter> chapterList;
	@Column(name = "total_duration")
	private String totalDuration;
	@Column(name = "category")
	private String category;
	@Column(name = "register_flag")
	private Integer registerFlag;
	@Column(name = "delete_flag")
	private Integer deleteFlag;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long courseId, String courseName, List<Chapter> chapterList, String totalDuration,
			String category, Integer registerFlag, Integer deleteFlag) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.chapterList = chapterList;
		this.totalDuration = totalDuration;
		this.category = category;
		this.registerFlag = registerFlag;
		this.deleteFlag = deleteFlag;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public String getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getRegisterFlag() {
		return registerFlag;
	}

	public void setRegisterFlag(Integer registerFlag) {
		this.registerFlag = registerFlag;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", chapterList=" + chapterList
				+ ", totalDuration=" + totalDuration + ", category=" + category
				+ ", registerFlag=" + registerFlag + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
