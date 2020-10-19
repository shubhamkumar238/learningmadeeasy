package com.learningmadeeasy.DAO;

import java.util.List;
import java.util.Map;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Student;

public interface StudentDAOInterface {

	void save(Student theStudent);

	int saveStudent(Map<String, ?> theStudent);

	void savecourseforstudent(int studentId, int courseId);

	List<Course> getAllCourses(int studentId);

}
