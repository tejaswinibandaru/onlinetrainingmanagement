package com.cg.onlinetraining.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("chapter")
@Entity
@Table(name = "chapter")
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chapter_id")
	private Long chapterId;
	@Column(name = "chapter_title")
	private String chapterTitle;
	@ManyToOne
	@JoinColumn(name = "course_fk")
	@Column(name = "course")
	private Course course;
	@Column(name="video_link")
	private String videoUrl;
	@Column(name = "bookmark_flag")
	private Integer bookmarkFlag;
	@Column(name = "delete_flag")
	private Integer deleteFlag;

	public Chapter() {
		// TODO Auto-generated constructor stub
	}

	public Chapter(Long chapterId, String chapterTitle, Course course, String videoUrl, Integer bookmarkFlag) {
		this.chapterId = chapterId;
		this.chapterTitle = chapterTitle;
		this.course = course;
		this.videoUrl = videoUrl;
		this.bookmarkFlag = bookmarkFlag;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Integer getBookmarkFlag() {
		return bookmarkFlag;
	}

	public void setBookmarkFlag(Integer bookmarkFlag) {
		this.bookmarkFlag = bookmarkFlag;
	}
	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterId == null) ? 0 : chapterId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		if (chapterId == null) {
			if (other.chapterId != null)
				return false;
		} else if (!chapterId.equals(other.chapterId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterTitle=" + chapterTitle + ", course=" + course
				+ ", videoUrl=" + videoUrl + ", bookmarkFlag=" + bookmarkFlag + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
