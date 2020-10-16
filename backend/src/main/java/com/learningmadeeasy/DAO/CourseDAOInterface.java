package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;

public interface CourseDAOInterface {

	List<Course> showAllCourses();

	Course showParticularCourse(int courseId);

	void saveNewCourse(Map<String, ?> theCourse);

	
	

}
