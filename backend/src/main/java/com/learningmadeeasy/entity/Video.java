package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="video")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="videoUrl")
public class Video {
	
	@Id
	@Column(name="video_url")
	private String videoUrl;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	public Video() {
		
	}
	
	public Video(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Video [videoUrl=" + videoUrl + ", course=" + course + "]";
	}
	
}	
