package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_details")
public class TeacherDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_details_id")
	private int teacherDetailsId;
	
	@Column(name="about")
	private String about;
	
	@Column(name="achievements")
	private String achievements;
	
	@Column(name="myobjectives")
	private String myobjectives;
	
	@Column(name="expert_category")
	private String expertCategory;
	
	@Column(name="extra_category")
	private String extraCategory; // stored as @@ strategy
	
	
	public TeacherDetails() {
		
	}
	
	public TeacherDetails(int teacherDetailsId, String about, String achievements, String myobjectives,
			String expertCategory, String extraCategory) {
		this.teacherDetailsId = teacherDetailsId;
		this.about = about;
		this.achievements = achievements;
		this.myobjectives = myobjectives;
		this.expertCategory = expertCategory;
		this.extraCategory = extraCategory;
	}


	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public String getMyobjectives() {
		return myobjectives;
	}

	public void setMyobjectives(String myobjectives) {
		this.myobjectives = myobjectives;
	}


	public int getTeacherDetailsId() {
		return teacherDetailsId;
	}


	public void setTeacherDetailsId(int teacherDetailsId) {
		this.teacherDetailsId = teacherDetailsId;
	}


	public String getExpertCategory() {
		return expertCategory;
	}


	public void setExpertCategory(String expertCategory) {
		this.expertCategory = expertCategory;
	}

	public String getExtraCategory() {
		return extraCategory;
	}

	public void setExtraCategory(String extraCategory) {
		this.extraCategory = extraCategory;
	}

}
