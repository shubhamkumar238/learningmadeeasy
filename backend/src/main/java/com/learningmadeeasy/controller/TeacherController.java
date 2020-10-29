
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
import com.learningmadeeasy.entity.Teacher;
import com.learningmadeeasy.service.TeacherServiceInterface;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	
	@Autowired
	private TeacherServiceInterface teacherserviceinterface;

	@PostMapping("/")
	public Teacher createTeacher(@RequestBody Teacher theTeacher) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theTeacher.setTeacherId(0);
		
		teacherserviceinterface.save(theTeacher);
		
		
		return theTeacher;
	}
	
	@GetMapping("/courses/{teacherId}")
	public List<Course> allCoursesOfTeacher(@PathVariable int teacherId){
		return teacherserviceinterface.allCoursesOfTeacher(teacherId);
	}
	
	@GetMapping("/rating/{teacherId}")
	public Map<String,Object> teacherRating(@PathVariable int teacherId){
		return teacherserviceinterface.teacherRating(teacherId);
		
	}
	
	@PostMapping("/topTeachers")
	public Map<String,Object> topTeachers(){
		return teacherserviceinterface.topTeachers();
	}
	
	
}

