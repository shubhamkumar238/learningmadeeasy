package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_student")
public class CourseStudent {

	@Id
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="student_id")
	private int studentId;
	
	public CourseStudent() {
		
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "CourseStudent [courseId=" + courseId + ", studentId=" + studentId + "]";
	}
	
	
	
}
