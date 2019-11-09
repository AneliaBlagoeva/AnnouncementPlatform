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
@Table(name="voluntariness")
public class Voluntariness implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="announcmnt_id")
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
	
	@Column(name="anncmnt_organization")
	private String anncmntOrganization;

	public Announcement getAnncmnt() {
		return anncmnt;
	}

	public void setAnncmnt(Announcement anncmnt) {
		this.anncmnt = anncmnt;
	}

	public String getAnncmntOrganization() {
		return anncmntOrganization;
	}

	public void setAnncmntOrganization(String anncmntOrganization) {
		this.anncmntOrganization = anncmntOrganization;
	}
}
