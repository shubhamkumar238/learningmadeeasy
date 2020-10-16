package com.learningmadeeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.entity.Teacher;
import com.learningmadeeasy.service.TeacherServiceInterface;

@RestController
@RequestMapping("/")
public class TeacherController {
	
	@Autowired
	private TeacherServiceInterface teacherserviceinterface;
	
	//added /home mapping
	
	@GetMapping("/home")
	public String home() {
		System.out.println("AGAIN testing eclipse pushing!");
		return "working";
	}
	
	@PostMapping("/teachers")
	public Teacher createTeacher(@RequestBody Teacher theTeacher) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theTeacher.setTeacherId(0);
		
		teacherserviceinterface.save(theTeacher);
		
		
		return theTeacher;
				
	}
}
