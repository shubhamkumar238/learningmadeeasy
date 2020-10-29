package com.learningmadeeasy.DAO;

import java.util.List;

public interface CourseCategoryDAOInterface {

	List<Object[]> showCategories();

	List<Object[]> studentsEnrolled();

	List<Object[]> countofEnrolledCourseCategory(String courseCategoryName);

	List<Object[]> getAllCoursesForThisCategory(String categoryName);

	List<Object[]> top10Courses();

}
