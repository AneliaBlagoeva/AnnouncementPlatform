package com.project.AnnouncementPlatform.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userjobattributes")
public class UserJobAttributes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_email")
	@MapsId
	private User user;

	public User getUser() {
		return user;
	}

	public void setAnncmnt(User user) {
		this.user = user;
	}

	@Column(name = "skills")
	private String skills;

	@Column(name = "experience")
	private int experience;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public UserJobAttributes() {
	}

	public UserJobAttributes(String email, User user, String skills, int experience) {
		this.email = email;
		this.user = user;
		this.skills = skills;
		this.experience = experience;
	}

}
