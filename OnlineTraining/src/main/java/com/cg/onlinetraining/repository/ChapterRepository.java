package com.cg.onlinetraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinetraining.dto.Chapter;
import com.cg.onlinetraining.dto.Course;

public interface ChapterRepository extends JpaRepository<Chapter, Long>{
	
	public Chapter findByChapterTitle(String chapterTitle);
	public Boolean existsByChapterTitle(String chapterTitle);
	public Chapter findByBookmarkFlag(Integer bookmarkFlag);
	public List<Chapter> findChapterByCourse(Course course);

}
