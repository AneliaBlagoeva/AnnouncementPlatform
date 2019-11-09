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
@Table(name = "scholarship")
public class Scholarship implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "anncmnt_id")
	private int anncmntID;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "anncmnt_id")
	@MapsId
	private Announcement anncmnt;

	@Column(name = "min_grade")
	private float minGrade;

	@Column(name = "scholarship_award")
	private float scholarshipAward;

	@Column(name = "requirements")
	private String requirements;
	
	@Column(name = "program_allowed")
	private String programAllowed;
	
	@Column(name = "university_allowed")
	private String universityAllowed;
	
	@Column(name = "year_allowed")
	private int yearAllowed;
	
	@Column(name = "degree_allowed")
	private String degreeAllowed;
	
	public int getAnncmntID() {
		return anncmntID;
	}

	public void setAnncmntID(int anncmntID) {
		this.anncmntID = anncmntID;
	}

	public int getYearAllowed() {
		return yearAllowed;
	}

	public void setYearAllowed(int yearAllowed) {
		this.yearAllowed = yearAllowed;
	}

	public String getDegreeAllowed() {
		return degreeAllowed;
	}

	public void setDegreeAllowed(String degreeAllowed) {
		this.degreeAllowed = degreeAllowed;
	}

	public String getProgramAllowed() {
		return programAllowed;
	}

	public void setProgramAllowed(String programAllowed) {
		this.programAllowed = programAllowed;
	}

	public String getUniversityAllowed() {
		return universityAllowed;
	}

	public void setUniversityAllowed(String universityAllowed) {
		this.universityAllowed = universityAllowed;
	}

	public Announcement getAnncmnt() {
		return anncmnt;
	}

	public void setAnncmnt(Announcement anncmnt) {
		this.anncmnt = anncmnt;
	}

	public float getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(float minGrade) {
		this.minGrade = minGrade;
	}

	public float getScholarshipAward() {
		return scholarshipAward;
	}

	public void setScholarshipAward(float scholarshipAward) {
		this.scholarshipAward = scholarshipAward;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

}
