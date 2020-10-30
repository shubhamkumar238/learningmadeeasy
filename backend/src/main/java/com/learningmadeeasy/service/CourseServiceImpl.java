package com.learningmadeeasy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learningmadeeasy.DAO.CourseDAOInterface;
import com.learningmadeeasy.entity.Course;

@Service
public class CourseServiceImpl implements CourseServiceInterface {
	
	@Autowired
	private CourseDAOInterface courseDAOInterface;
	
	@Autowired
	private EntityManager entityManager;
	
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
	@Transactional
	public int saveNewCourse(Map<String, ?> theCourse) {
		return courseDAOInterface.saveNewCourse(theCourse);
	}
	
	@Override
	@Transactional
	public String top10Courses(){
		
		List<Object[]> theCourses = courseDAOInterface.top10Courses();
		
		return null;
	}
	

}
