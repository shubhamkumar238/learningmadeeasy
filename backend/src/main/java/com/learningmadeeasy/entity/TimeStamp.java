package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="timestamp")
public class TimeStamp {
	
	@Id
	@Column(name="video_url")
	private String videoUrl;
	  
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="resume_time")
	private int resumeTime;
	
	public TimeStamp() {
		
	}
	
	public TimeStamp(String videoUrl, int studentId, int courseId, int resumeTime) {
		this.videoUrl = videoUrl;
		this.studentId = studentId;
		this.courseId = courseId;
		this.resumeTime = resumeTime;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getResumeTime() {
		return resumeTime;
	}

	public void setResumeTime(int resumeTime) {
		this.resumeTime = resumeTime;
	}

	@Override
	public String toString() {
		return "TimeStamp [videoUrl=" + videoUrl + ", studentId=" + studentId + ", courseId=" + courseId
				+ ", resumeTime=" + resumeTime + "]";
	}
	
}
