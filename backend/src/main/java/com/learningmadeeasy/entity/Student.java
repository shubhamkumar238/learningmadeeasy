package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="first_name")
	private String student_first_name;
	
	@Column(name="last_name")
	private String student_last_name;
	
	@Column(name="email")
	private String student_email;
	
	public Student() {
		
	}
	
	

	public Student(String student_first_name, String student_last_name, String student_email) {
		this.student_first_name = student_first_name;
		this.student_last_name = student_last_name;
		this.student_email = student_email;
	}



	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}



	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_first_name=" + student_first_name
				+ ", student_last_name=" + student_last_name + ", student_email=" + student_email + "]";
	}

	
	
	
}
