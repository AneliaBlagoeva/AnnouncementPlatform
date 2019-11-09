package com.project.AnnouncementPlatform.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String fName;

	@Column(name="last_name")
	private String lName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="city")
	private String city;
	
	@Column(name="phone")
	private String phone;

	@Column(name="country")
	private String country;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return fName;
	}
	public void setFirstName(String fName) {
		this.fName = fName;
	}
	
	public String getLastName() {
		return lName;
	}
	public void setLastName(String lName) {
		this.lName = lName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
