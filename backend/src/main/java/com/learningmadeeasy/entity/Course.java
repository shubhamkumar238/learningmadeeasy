package com.learningmadeeasy.entity;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="course_name")
	private String courseName;
		
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	@OneToMany(mappedBy="course")
	private List<Question> questions;
	
	@ManyToMany()
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;
	
	
	@OneToMany(mappedBy="course")
	private List<Answer> answers;
	
	@OneToMany(mappedBy="course")
	private List<Video> videos;
	
	@OneToMany(mappedBy="course")
	private List<Rating> ratings;
	
	
	public Course() {
		
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public void addStudent(Student theStudent) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
		students.add(theStudent);
	}
	
}
