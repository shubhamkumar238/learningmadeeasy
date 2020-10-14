package com.learningmadeeasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.CourseDAOImpl;
import com.learningmadeeasy.entity.Course;

@Service
public class CourseServiceImpl implements CourseServiceInterface {
	
	@Autowired
	private CourseDAOImpl courseDAOImpl;
	
	@Override
	@Transactional
	public List<Course> showAllCourses(){
		return courseDAOImpl.showAllCourses();
	}
	
	@Override
	@Transactional
	public Course showParticularCourse(int courseId) {
		return courseDAOImpl.showParticularCourse(courseId);
	}

}
