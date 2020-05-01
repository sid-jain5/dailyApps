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
		UserEntity userEntity=entityManager.find(UserEntity.class,user.getUsername());
		if(userEntity!=null) {
			userEntity.setEmailId(user.getEmailId());
			userEntity.setUsername(user.getUsername());
			userEntity.setName(user.getName());
			userEntity.setPhoneNumber(user.getPhoneNumber());
			userEntity.setPassword(user.getPassword());
			userEntity.setSecurityQuestion(user.getSecurityQuestion());
			userEntity.setSecurityAnswer(user.getSecurityAnswer());
			
			return userEntity.getUsername();
		
		}
		return userEntity.getUsername();
	}

	@Override
	public List<String> getUsernameList() throws Exception {
		// TODO Auto-generated method stub
		List<String> usernameList=new ArrayList<String>();
		return null;
	}

	@Override
	public Boolean checkAvailabilityOfUsername(String username) {
		// TODO Auto-generated method stub
		Boolean flag = false;

		UserEntity userEntity = null;

		userEntity = entityManager.find(UserEntity.class, username);

		if(userEntity == null)
			flag = true;

		return flag;
	}

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class,username);
		entityManager.remove(userEntity);
		return userEntity.getUsername();
	}
	
	



}
