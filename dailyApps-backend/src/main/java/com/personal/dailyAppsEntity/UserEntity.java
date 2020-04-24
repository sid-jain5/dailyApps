package com.personal.dailyAppsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="HASHED_PASSWORD")
	private String hashedPassword;
	
	@Column(name="SECURITY_QUESTION")
	private String securityQuestion;
	
	@Column(name="SECURITY_ANSWER")
	private String securityAnswer;
//	EMAIL_ID VARCHAR(50) NOT NULL UNIQUE,
//	USERNAME VARCHAR(15) NOT NULL UNIQUE,
//	NAME VARCHAR(50) NOT NULL,	
//	PHONE_NUMBER VARCHAR(10) NOT NULL UNIQUE,
//	PASSWORD VARCHAR(20) NOT NULL,
//	HASHED_PASSWORD VARCHAR(100) NOT NULL,
//	SECURITY_QUESTION VARCHAR(50),
//	SECURITY_ANSWER VARCHAR(20),

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	
}
