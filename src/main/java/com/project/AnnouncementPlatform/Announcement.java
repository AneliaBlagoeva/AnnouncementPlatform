package com.project.AnnouncementPlatform;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement {
	
	@Id
	@Column(name="announcement_id")
	private int anncmntId;
	
	@Column(name="anncmnt_name")
	private String anncmntName;
	
	@Column(name="status_id")
	@JoinColumn(name="statusId")
	private int statusId;
	
	@Column(name="anncmnt_category_id")
	@JoinColumn(name="categoryId")
	private int anncmntCategoryId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="url")
	private String url;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="user_email")
	@JoinColumn(name="email")
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
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getAnncmntCategoryId() {
		return anncmntCategoryId;
	}
	public void setAnncmntCategoryId(int anncmntCategory) {
		this.anncmntCategoryId = anncmntCategory;
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

}
