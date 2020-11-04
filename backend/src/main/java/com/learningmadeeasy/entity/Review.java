package com.learningmadeeasy.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Review {
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="review")
	private String review;
	
	@Column(name="reviewer_first_name")
	private String reviewerFirstName;
	
	@Column(name="reviewer_last_name")
	private String reviewerLastName;
	
	@Column(name="review_date")
	private Date reviewDate;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getReviewerFirstName() {
		return reviewerFirstName;
	}
	public void setReviewerFirstName(String reviewerFirstName) {
		this.reviewerFirstName = reviewerFirstName;
	}
	public String getReviewerLastName() {
		return reviewerLastName;
	}
	public void setReviewerLastName(String reviewerLastName) {
		this.reviewerLastName = reviewerLastName;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	public Review() {
		
	}
	
	public Review(int rating, String review, String reviewerFirstName, String reviewerLastName, Date reviewDate) {
		this.rating = rating;
		this.review = review;
		this.reviewerFirstName = reviewerFirstName;
		this.reviewerLastName = reviewerLastName;
		this.reviewDate = reviewDate;
	}
	
}
