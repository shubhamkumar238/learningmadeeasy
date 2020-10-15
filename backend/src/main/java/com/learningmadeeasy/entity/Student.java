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
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String student_email;
	
	
	@ManyToMany
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)	
	private List<Course> courses;
	

	public Student(int student_id, String name, String student_email) {
		this.student_id = student_id;
		this.name = name;
		this.student_email = student_email;
	}
	
	public Student() {
		
	}

	public Student(String name, String student_email) {
		this.name = name;
		this.student_email = student_email;
	}
	
	
	
	
}
