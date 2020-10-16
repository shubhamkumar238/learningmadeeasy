package com.learningmadeeasy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Teacher;
import com.learningmadeeasy.service.CourseServiceInterface;

@RestController
@RequestMapping("/")
public class CourseController {
	
	private CourseServiceInterface courseserviceinterface;
	
	
	@GetMapping("/courses")
	public List<Course> ShowAllCourses(){
		
		return courseserviceinterface.showAllCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course ShowParticularCourse(@PathVariable int courseId) {
		return courseserviceinterface.showParticularCourse(courseId);
	}
	
	@PostMapping("/courses")
	public int CreateCourse(@RequestBody Course theCourse, int teacherId) {
		
		theCourse.setCourseId(0);
		
		courseserviceinterface.save(theCourse);
		
		return theCourse.getCourseId();
		
		
	}
	
	
	
}
