package com.learningmadeeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningmadeeasy.entity.Video;
import com.learningmadeeasy.service.VideoServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {
	
	@Autowired
	private VideoServiceInterface videoServiceInterface;
	
	@PostMapping("/uploadVideo")
	public void videoUploadfn(@RequestBody Video video){
		videoServiceInterface.saveTheVideo(video);
	}
	
	@GetMapping("/courseVideos/{courseId}")
	public List<String> theCourseVideo( @PathVariable int courseId){
		return videoServiceInterface.theCourseVideo(courseId);
	}
	
	@GetMapping("/allCourses")
	public List<Integer> allCourses(){
		return videoServiceInterface.getAllCourses();
	}
}
