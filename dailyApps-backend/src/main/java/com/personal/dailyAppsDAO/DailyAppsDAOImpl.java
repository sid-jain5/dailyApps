package com.personal.dailyAppsDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.dailyApps.DailyAppsApplication;
import com.personal.dailyAppsEntity.UserEntity;
import com.personal.dailyAppsModel.Users;

public class DailyAppsDAOImpl implements DailyAppsDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Users getUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class, username);
//		private String emailId;
//		private String username;
//		private String name;
//		private String phoneNumber;
//		private String password;
//		private String hashedPassword;
//		private String securityQuestion;
//		private String securityAnswer;
		Users users=null;
		users.setEmailId(userEntity.getEmailId());
		users.setUsername(username);
		users.setName(userEntity.getName());
		users.setPhoneNumber(userEntity.getPhoneNumber());
		users.setPassword(userEntity.getPassword());
		users.setSecurityQuestion(userEntity.getSecurityQuestion());
		users.setSecurityAnswer(userEntity.getSecurityAnswer());
		
		return users;
	}

	@Override
	public String addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUsernameList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	} 

//	@Override
//	public boolean authenticateUser(String emailId, String password) {
//		// TODO Auto-generated method stub
//		Query query=entityManager.createQuery("SELECT USERNAME FROM UserEntity WHERE EMAIL_ID=:emailId");
//		List<String> usernameList=new ArrayList<String>();
//		usernameList=query.getResultList();
//		Query query1=entityManager.createQuery("SELECT PASSWORD FROM UserEntity WHERE EMAIL_ID=:emailId");
//		List<String> passwordList=new ArrayList<String>();
//		passwordList=query.getResultList();
//		for (String string : passwordList) {
//			for (String string2 : usernameList) {
//				if(string==password)
//					return true;
//			}
//		}
//		return false;
//	}


}
