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
	private int studentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	
	@ManyToMany
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="studentId"),
			inverseJoinColumns=@JoinColumn(name="courseId")
			)	
	private List<Course> courses;

	public Student() {
		
	}
	
	public Student(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}

	
}
