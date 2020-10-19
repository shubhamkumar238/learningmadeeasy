package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.VideoDAOInterface;
import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Video;

@Service
public class VideoServiceImpl implements VideoServiceInterface {

	@Autowired
	private VideoDAOInterface videoDAOInterface;
	
	@Override
	@Transactional
	public void saveTheVideo(Map<String, ?> video) {
		videoDAOInterface.saveTheVideo(video);
		
	}

	@Override
	@Transactional
	public List<Video> theCourseVideo(int courseId) {
		return videoDAOInterface.theCourseVideo(courseId);
	}

	@Override
	@Transactional
	public List<Course> getAllCourses() {
		return videoDAOInterface.getAllCourses();
	}

}
