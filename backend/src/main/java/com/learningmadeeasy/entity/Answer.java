package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question problem;
	
	@JsonIgnore
	@Column(name="response")
	private String response;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	public Answer() {
		
	}
	
	public Answer(String response) {
		this.response = response;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public Question getProblem() {
		return problem;
	}

	public void setProblem(Question problem) {
		this.problem = problem;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", problem=" + problem + ", response=" + response + ", course=" + course
				+ "]";
	}
	
}
