package com.learningmadeeasy.service;

import java.util.List;

import com.learningmadeeasy.entity.Video;

public interface VideoServiceInterface {

	void saveTheVideo(Video video);
	
	List<String> theCourseVideo(int courseId);

	List<Integer> getAllCourses();
	
}
