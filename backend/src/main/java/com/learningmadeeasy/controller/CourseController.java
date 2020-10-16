package com.learningmadeeasy.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.service.CourseServiceInterface;
import com.learningmadeeasy.service.TeacherServiceInterface;

@RestController
@RequestMapping("/")
public class CourseController {
	
	@Autowired
	private CourseServiceInterface courseserviceinterface;
	
	@Autowired
	private TeacherServiceInterface teacherserviceinterface;
	
	@Autowired
	private EntityManager entityManager;
	
	
	@GetMapping("/courses")
	public List<Course> ShowAllCourses(){
		
		return courseserviceinterface.showAllCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course ShowParticularCourse(@PathVariable int courseId) {
		return courseserviceinterface.showParticularCourse(courseId);
	}
	
	@PostMapping("/courses")
	public int CreateCourse(@RequestBody Map<String,?> theCourse) {

		
		courseserviceinterface.saveNewCourse(theCourse);
		
		return 0;
		
		
	}
	
	
	
}
