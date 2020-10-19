package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Video;

public interface VideoDAOInterface {

	void saveTheVideo(Map<String, ?> video);

	List<Video> theCourseVideo(int courseId);

	List<Course> getAllCourses();

}
