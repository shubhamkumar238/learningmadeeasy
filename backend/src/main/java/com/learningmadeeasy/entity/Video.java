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
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="video_name")
	private int videoName;
	
	@Column(name="video_description")
	private int videoDescription;

	public Video() {
		
	}
	
	public Video(String videoUrl, int duration, int videoName, int videoDescription) {
		this.videoUrl = videoUrl;
		this.duration = duration;
		this.videoName = videoName;
		this.videoDescription = videoDescription;
	}


	public int getVideoName() {
		return videoName;
	}

	public void setVideoName(int videoName) {
		this.videoName = videoName;
	}

	public int getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(int videoDescription) {
		this.videoDescription = videoDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
	
}	
