package com.learningmadeeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.CourseDAOInterface;
import com.learningmadeeasy.entity.Course;

@Service
public class CourseServiceImpl implements CourseServiceInterface {
	
	@Autowired
	private CourseDAOInterface courseDAOInterface;
	
	@Override
	@Transactional
	public List<Course> showAllCourses(){
		return courseDAOInterface.showAllCourses();
	}
	
	@Override
	@Transactional
	public Course showParticularCourse(int courseId) {
		return courseDAOInterface.showParticularCourse(courseId);
	}

	@Override
	public void saveNewCourse(Map<String, ?> theCourse) {
		courseDAOInterface.saveNewCourse(theCourse);
	}
	

}
