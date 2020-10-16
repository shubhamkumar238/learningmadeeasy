package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {
	
	@Id
	@Column(name="video_url")
	private int videoUrl;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	public Video() {
		
	}
	
	public Video(int videoUrl, Course course) {
		this.videoUrl = videoUrl;
		this.course = course;
	}

	public int getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(int videoUrl) {
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
