package com.learningmadeeasy.DAO;

import java.util.List;

import com.learningmadeeasy.entity.Video;

public interface VideoDAOInterface {

	void saveTheVideo(Video video);

	List<String> theCourseVideo(int courseId);

	List<Integer> getAllCourses();

}
