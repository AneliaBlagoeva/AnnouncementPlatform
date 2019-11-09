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
@Table(name="job")
public class Job implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="anncmnt_id")
	private int anncmntID;
	
    public int getAnncmntID() {
		return anncmntID;
	}

	public void setAnncmntID(int anncmntID) {
		this.anncmntID = anncmntID;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anncmnt_id")
    @MapsId
	private Announcement anncmnt;
	
	public Announcement getAnncmnt() {
		return anncmnt;
	}

	public void setAnncmnt(Announcement anncmnt) {
		this.anncmnt = anncmnt;
	}

	@Column(name="anncmnt_organization")
	private String anncmntOrganization;
	
	@Column(name="candidate_responsibility")
	private String candidateResponsibility;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="experience")
	private int experiance;
	
	@Column(name="benefits")
	private String benefits;
	
	@Column(name="requirements")
	private String requirements;

	public String getAnncmntOrganization() {
		return anncmntOrganization;
	}

	public void setAnncmntOrganization(String anncmntOrganization) {
		this.anncmntOrganization = anncmntOrganization;
	}

	public String getCandidateResponsibility() {
		return candidateResponsibility;
	}

	public void setCandidateResponsibility(String candidateResponsibility) {
		this.candidateResponsibility = candidateResponsibility;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

}
