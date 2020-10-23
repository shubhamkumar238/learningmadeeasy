package com.learningmadeeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher_details")
public class Teacher_Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_details_id")
	private int teacher_details_id;
	
	@Column(name="about")
	private String about;
	
	@Column(name="achievements")
	private String achievements;
	
	@Column(name="myobjectives")
	private String myobjectives;
	
	@Column(name="expert_category")
	private String expert_category;
	
	@Column(name="extra_category")
	private String extra_category;
	
	@OneToOne(mappedBy ="teacher_details")
	private Teacher teacher;
	
	public Teacher_Details() {
		
	}
	

	public Teacher_Details(String about, String achievements, String myobjectives,
			String expert_category, String extra_category) {
		this.about = about;
		this.achievements = achievements;
		this.myobjectives = myobjectives;
		this.expert_category = expert_category;
		this.extra_category = extra_category;
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

	public String getExpert_category() {
		return expert_category;
	}

	public void setExpert_category(String expert_category) {
		this.expert_category = expert_category;
	}

	public String getExtra_category() {
		return extra_category;
	}

	public void setExtra_category(String extra_category) {
		this.extra_category = extra_category;
	}


	@Override
	public String toString() {
		return "Teacher_Details [teacher_details_id=" + teacher_details_id + ", about=" + about + ", achievements="
				+ achievements + ", myobjectives=" + myobjectives + ", expert_category=" + expert_category
				+ ", extra_category=" + extra_category + "]";
	}
	
	

}
