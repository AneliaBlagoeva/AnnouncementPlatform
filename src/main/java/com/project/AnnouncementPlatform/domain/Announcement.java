package com.project.AnnouncementPlatform.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="announcement_id")
	private int anncmntId;
	
	@Column(name="anncmnt_name")
	private String anncmntName;
	
	@ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "status_id")
	private AnnouncementStatus status;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "anncmnt_category_id")
	private AnnouncementCategory category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="url")
	private String url;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="user_email")
	private String userEmail;
	
	public int getAnncmntId() {
		return anncmntId;
	}
	public void setAnncmntId(int anncmntId) {
		this.anncmntId = anncmntId;
	}
	public String getAnncmntName() {
		return anncmntName;
	}
	public void setAnncmntName(String anncmntName) {
		this.anncmntName = anncmntName;
	}
	
	public AnnouncementStatus getStatus() {
		return status;
	}
	public void setStatus(AnnouncementStatus status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public AnnouncementCategory getCategory() {
		return category;
	}
	
	public void setCategory(AnnouncementCategory category) {
		this.category = category;
	}
	
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Announcement(int anncmntId, String anncmntName, AnnouncementStatus status, AnnouncementCategory category,
			String description, String url, Date dateCreated, String userEmail) {
		super();
		this.anncmntId = anncmntId;
		this.anncmntName = anncmntName;
		this.status = status;
		this.category = category;
		this.description = description;
		this.url = url;
		this.dateCreated = dateCreated;
		this.userEmail = userEmail;
	}
	
	

}
