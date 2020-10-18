package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rating_id")
	private int ratingId;
	
	@Column(name="course_rating")
	private int courseRating;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	public Rating() {
		
	}
	
	public Rating(int courseRating) {
		this.courseRating = courseRating;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(int courseRating) {
		this.courseRating = courseRating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", courseRating=" + courseRating + ", course=" + course + "]";
	}
	
	
}
