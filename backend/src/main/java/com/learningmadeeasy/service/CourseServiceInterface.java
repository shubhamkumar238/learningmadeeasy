package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;

public interface CourseServiceInterface {

	List<Course> showAllCourses();

	Course showParticularCourse(int courseId);

	int saveNewCourse(Map<String, ?> theCourse);

	String top10Courses();

}
