package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="answer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="answerId")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question problem;
	
	
	@Column(name="response")
	private String response;
	
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

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", problem=" + problem + ", response=" + response + "]";
	}
	
}
