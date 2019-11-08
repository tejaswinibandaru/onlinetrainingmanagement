package com.cg.onlinetraining.service;

import java.util.List;

import com.cg.onlinetraining.dto.Chapter;
import com.cg.onlinetraining.dto.Course;
import com.cg.onlinetraining.exception.OTMSException;

public interface ChapterService {
	
	public Chapter addChapter(Chapter chapter) throws OTMSException;
	public Integer removeChapter(Long chapterId) throws OTMSException;
	public Chapter updateChapter(Long chapterId,String videoUrl)throws OTMSException ;
	public List<Chapter> viewAllChapters(Course course);
	public Chapter viewByChapterTitle(String chapterTitle) throws OTMSException;
	public Chapter bookmarkChapter(Long chapterId) throws OTMSException;
	public Chapter viewChapter(Long chapterId) throws OTMSException;

}
