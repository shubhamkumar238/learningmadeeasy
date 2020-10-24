package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_category")
public class CourseCategory {
	@Id
	@Column(name="course_category_name")
	private String courseCategoryName;
	
	@Column(name="category_url")
	private String categoryUrl;

	public String getCourseCategoryName() {
		return courseCategoryName;
	}

	public void setCourseCategoryName(String courseCategoryName) {
		this.courseCategoryName = courseCategoryName;
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	
	
	public CourseCategory() {
		
	}

	public CourseCategory(String courseCategoryName, String categoryUrl) {
		this.courseCategoryName = courseCategoryName;
		this.categoryUrl = categoryUrl;
	}
	
	

}
