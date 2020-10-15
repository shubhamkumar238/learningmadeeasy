package com.learningmadeeasy.service;

import java.util.List;

import com.learningmadeeasy.entity.Course;

public interface CourseServiceInterface {

	List<Course> showAllCourses();

	Course showParticularCourse(int courseId);

	void save(Course theCourse);

}
