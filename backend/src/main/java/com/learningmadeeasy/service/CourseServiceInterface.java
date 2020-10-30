package com.learningmadeeasy.service;

import java.util.Map;

import com.learningmadeeasy.entity.Course;

public interface CourseServiceInterface {

	String showAllCourses();

	Course showParticularCourse(int courseId);

	int saveNewCourse(Map<String, ?> theCourse);

	String getCourseFeatures(int courseId);

	String getSimilarCourseForCategory(String courseCategory);

}
