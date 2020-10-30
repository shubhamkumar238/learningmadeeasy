package com.learningmadeeasy.service;

import java.util.Map;

public interface CourseCategoryServiceInterface {

	String showCategories();

	Map<String, Object> studentsEnrolled();

	Map<String, Object> countofEnrolledCourseCategory(String courseCategoryName);

	Map<String, Object> getAllCoursesForThisCategory(String categoryName);

}
