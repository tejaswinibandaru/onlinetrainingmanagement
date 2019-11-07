package com.cg.onlinetraining.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetraining.dto.Chapter;
import com.cg.onlinetraining.dto.Course;
import com.cg.onlinetraining.exception.OTMSException;
import com.cg.onlinetraining.repository.ChapterRepository;

@Service
public class ChapterServiceImpl implements ChapterService {
	
	@Autowired
	ChapterRepository chapterRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ChapterServiceImpl.class);
	@Override
	public Chapter addChapter(Chapter chapter) throws OTMSException {
		// TODO Auto-generated method stub
		if(chapter==null) {
			throw new OTMSException("Chapter found to be null");
		}
		if(chapterRepository.existsByChapterTitle(chapter.getChapterTitle())) {
			throw new OTMSException("Chapter already exists");
		}
		chapter.setCourse(chapter.getCourse());
		chapter.setDeleteFlag(0);
		chapterRepository.save(chapter);
		logger.info("Chapter added to course: "+chapter.getChapterTitle());
		return chapter;
	}

	@Override
	public Integer removeChapter(Long chapterId) throws OTMSException {
		// TODO Auto-generated method stub
		Chapter chapter=chapterRepository.findById(chapterId).get();
		if(chapter==null) {
			throw new OTMSException("Chapter not found");
		}
		chapter.setDeleteFlag(1);
		chapterRepository.save(chapter);
		return 1;
	}

	@Override
	public Chapter updateChapter(Long chapterId,String videoUrl) throws OTMSException {
		// TODO Auto-generated method stub
		Chapter chapter=chapterRepository.findById(chapterId).get();
		if(chapter==null) {
			throw new OTMSException("Chapter not found");
		}
		if(videoUrl==null) {
			throw new OTMSException("VideoURL is empty");
		}
		chapter.setVideoUrl(videoUrl);
		return chapter;
	}

	@Override
	public List<Chapter> viewAllChapters(Course course) {
		// TODO Auto-generated method stub
		return chapterRepository.findChapterByCourse(course);
	}

	@Override
	public Chapter viewByChapterTitle(String chapterTitle) throws OTMSException {
		// TODO Auto-generated method stub
		if(chapterTitle==null) {
			throw new OTMSException("Chapter title is empty");
		}
		return chapterRepository.findByChapterTitle(chapterTitle);
	}

	@Override
	public Chapter bookmarkChapter(Long chapterId) throws OTMSException {
		// TODO Auto-generated method stub
		Chapter chapter=chapterRepository.findById(chapterId).get();
		if(chapter==null) {
			throw new OTMSException("Chapter not found");
		}
		chapter.setBookmarkFlag(1);
		return chapter;
	}

}
