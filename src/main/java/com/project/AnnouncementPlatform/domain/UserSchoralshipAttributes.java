package com.project.AnnouncementPlatform.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userschoralshipattributes")
public class UserSchoralshipAttributes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_email")
	@MapsId
	private User user;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "degree")
	private Degree degree;

	@Column(name = "grade")
	private float grade;

	@Column(name = "university")
	private String university;

	@Column(name = "program")
	private String program;

	@Column(name = "year")
	private int year;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public UserSchoralshipAttributes(String email, User user, Degree degree, float grade, String university,
			String program, int year) {
		this.email = email;
		this.user = user;
		this.degree = degree;
		this.grade = grade;
		this.university = university;
		this.program = program;
		this.year = year;
	}

	public UserSchoralshipAttributes() {
	}

}
