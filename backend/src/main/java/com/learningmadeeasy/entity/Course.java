package com.learningmadeeasy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="course_name")
	private String course_name;
		
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	
	@ManyToMany()
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;
	
	
	public Course() {
		
	}

	
	public Course(String course_name, Teacher teacher) {
		this.course_name = course_name;
		this.teacher = teacher;
	}

	

	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", teacher=" + teacher + "]";
	}


	
	
	
}
