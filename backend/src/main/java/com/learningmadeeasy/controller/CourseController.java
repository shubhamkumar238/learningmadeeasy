package com.learningmadeeasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	
	@Autowired
	private CourseServiceInterface courseserviceinterface;
	
	
	@GetMapping("/")
	public List<Course> ShowAllCourses(){
		
		return courseserviceinterface.showAllCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course ShowParticularCourse(@PathVariable int courseId) {
		return courseserviceinterface.showParticularCourse(courseId);
	}
	
	@PostMapping("/create")
	public int CreateCourse(@RequestBody Map<String,?> theCourse) {
		
		return courseserviceinterface.saveNewCourse(theCourse);
		
	}
	
	@GetMapping("/top10Courses")
	public String top10Courses(){
		return courseserviceinterface.top10Courses();
	}
	
	
	
}
