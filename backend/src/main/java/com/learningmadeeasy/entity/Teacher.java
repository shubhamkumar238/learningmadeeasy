package com.learningmadeeasy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="teacher")
	private List<Course> courses;

	
	public int getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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


	public Teacher() {
		
	}

	
	public Teacher(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}

}
