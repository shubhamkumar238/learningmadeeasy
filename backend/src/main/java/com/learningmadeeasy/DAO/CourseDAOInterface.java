package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;

public interface CourseDAOInterface {

	List<Object[]> showAllCourses();

	Course showParticularCourse(int courseId);

	int saveNewCourse(Map<String, ?> theCourse);

	List<Object[]> getCourseFeatures(int courseId);

	List<Object[]> getSimilarCourseForCategory(String courseCategory);

}
