package com.personal.dailyAppsModel;

public class Users {
	
//	EMAIL_ID VARCHAR(50) NOT NULL UNIQUE,
//	USERNAME VARCHAR(15) NOT NULL UNIQUE,
//	NAME VARCHAR(50) NOT NULL,	
//	PHONE_NUMBER VARCHAR(10) NOT NULL UNIQUE,
//	PASSWORD VARCHAR(20) NOT NULL,
//	HASHED_PASSWORD VARCHAR(100) NOT NULL,
//	SECURITY_QUESTION VARCHAR(50),
//	SECURITY_ANSWER VARCHAR(20),
	
	private String emailId;
	private String username;
	private String name;
	private String phoneNumber;
	private String password;
	private String hashedPassword;
	private String securityQuestion;
	private String securityAnswer;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
