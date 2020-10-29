package com.learningmadeeasy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.service.CourseCategoryServiceInterface;

@RestController
@RequestMapping("/categories")
//@CrossOrigin(origins = "http://localhost:4200")
public class CourseCategory {
	
	@Autowired
	private CourseCategoryServiceInterface courseCategoryServiceInterface;
	
	//used map strategy for serialization
	//shows list of available categories along with other details
	@GetMapping("/")
	public Map<String,Object> showCategories(){
		
		return courseCategoryServiceInterface.showCategories();
		
	}
	
	
	@GetMapping("/{categoryName}")
	public Map<String,Object> getAllCoursesForThisCategory(@PathVariable String categoryName){
		
		return courseCategoryServiceInterface.getAllCoursesForThisCategory(categoryName);
	}
	
	@GetMapping("/top10Courses")
	public Map<String,Object> top10Courses(){
		return courseCategoryServiceInterface.top10Courses();
	}
	
	
	//shows total students enrolled under each category
	//future ref
	@GetMapping("/studentsenrolled")
	public Map<String,Object> showStudentsEnrolled(){
			
		return courseCategoryServiceInterface.studentsEnrolled();
	}
		
		
	//future reference
	@GetMapping("/underOneCategory/{courseCategory}")
	public Map<String,Object> countofEnrolledCourseCategory(@PathVariable String courseCategory) {
		
		return courseCategoryServiceInterface.countofEnrolledCourseCategory(courseCategory);
	}
	
	

}
