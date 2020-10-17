package com.learningmadeeasy.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.entity.Course;
import com.learningmadeeasy.entity.Student;
import com.learningmadeeasy.service.StudentServiceInterface;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	
	@PostMapping("/students")
	private void save(@RequestBody Student theStudent) {
		studentServiceInterface.save(theStudent);
	}
		
	@PostMapping("/{studentId}/{courseId}")
	public void createStudent(@PathVariable int studentId, @PathVariable int courseId) {
		
		studentServiceInterface.savecourseforstudent(studentId,courseId);
		
	}
	
	@GetMapping("/findcourses/{studentId}")
	public List<Course> getAllCourses(@PathVariable int studentId){
		
		return studentServiceInterface.getAllCourses(studentId);
	}
	
	
	
}
