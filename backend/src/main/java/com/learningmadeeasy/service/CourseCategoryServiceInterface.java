package com.learningmadeeasy.service;

import java.util.Map;

public interface CourseCategoryServiceInterface {

	Map<String,Object> showCategories();

	Map<String, Object> studentsEnrolled();

	Map<String, Object> countofEnrolledCourseCategory(String courseCategoryName);

	Map<String, Object> getAllCoursesForThisCategory(String categoryName);

	Map<String, Object> top10Courses();

}
