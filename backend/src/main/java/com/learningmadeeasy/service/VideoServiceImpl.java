package com.learningmadeeasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.VideoDAOInterface;
import com.learningmadeeasy.entity.Video;

@Service
public class VideoServiceImpl implements VideoServiceInterface {

	@Autowired
	private VideoDAOInterface videoDAOInterface;
	
	@Override
	@Transactional
	public void saveTheVideo(Video video) {
		videoDAOInterface.saveTheVideo(video);
		
	}

	@Override
	@Transactional
	public List<String> theCourseVideo(int courseId) {
		return videoDAOInterface.theCourseVideo(courseId);
	}

	@Override
	@Transactional
	public List<Integer> getAllCourses() {
		return videoDAOInterface.getAllCourses();
	}

}
