package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Student;


public interface StudentServiceInterface {

	void save(Student theStudent);

	int saveStudent(Map<String, ?> theStudent);

	void savecourseforstudent(int studentId, int courseId);

	List<Course> getAllCourses(int studentId);

}
