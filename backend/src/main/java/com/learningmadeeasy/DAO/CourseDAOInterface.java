package com.learningmadeeasy.DAO;

import java.util.List;

import com.learningmadeeasy.entity.Course;

public interface CourseDAOInterface {

	List<Course> showAllCourses();

	Course showParticularCourse(int courseId);

	void save(Course theCourse);
	

}
