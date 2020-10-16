package com.learningmadeeasy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="problem")
	private String problem;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@OneToMany(mappedBy="problem")
	private List<Answer> answers;
	
	public Question() {
		
	}
	
	public Question(String problem) {
		this.problem = problem;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", problem=" + problem + ", course=" + course + ", answers="
				+ answers + "]";
	}
	
}
