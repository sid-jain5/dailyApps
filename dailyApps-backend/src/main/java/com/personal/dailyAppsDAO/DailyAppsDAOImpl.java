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
		
		////////// new code added /////////
		if(userEntity==null) {
			//for debugging purpose
			System.out.println("user not found dao");
			
			return users;
		}
		
		
		users = new Users();
		///////////////
		
		users.setEmailId(userEntity.getEmailId());
		users.setUsername(username);
		users.setName(userEntity.getName());
		users.setPhoneNumber(userEntity.getPhoneNumber());
		users.setPassword(userEntity.getPassword());
		users.setSecurityQuestion(userEntity.getSecurityQuestion());
		users.setSecurityAnswer(userEntity.getSecurityAnswer());
		users.setHashedPassword(userEntity.getHashedPassword()); // line added 
		return users;
	}

	@Override
	public String addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = new UserEntity();
		
//		UserEntity userEntity=entityManager.find(UserEntity.class,user.getUsername());
//		if(userEntity!=null) { 
		//new user will be added when userEntity is null and that will be checked with getUserByUsername func in service class
		userEntity.setEmailId(user.getEmailId());
		userEntity.setUsername(user.getUsername());
		userEntity.setName(user.getName());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		userEntity.setPassword(user.getPassword());
		userEntity.setSecurityQuestion(user.getSecurityQuestion());
		userEntity.setSecurityAnswer(user.getSecurityAnswer());
		userEntity.setHashedPassword(user.getHashedPassword());
		
		entityManager.persist(userEntity);
			
		return userEntity.getUsername();
//		
//		}
	}

	@Override
	public List<String> getUsernameList() throws Exception {
		// TODO Auto-generated method stub
		Query q = entityManager.createQuery("SELECT u.username from UserEntity u");
		List<String> usernameList = q.getResultList();
		return usernameList;
	}

	//// not needed -- can be done with getUserByUsername and checkAvailabilityOfUsername logic will be in service class
//	@Override
//	public Boolean checkAvailabilityOfUsername(String username) {
//		// TODO Auto-generated method stub
//		Boolean flag = false;
//
//		UserEntity userEntity = null;
//
//		userEntity = entityManager.find(UserEntity.class, username);
//
//		if(userEntity == null)
//			flag = true;
//
//		return flag;
//	}

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class,username);
		entityManager.remove(userEntity);
		return userEntity.getUsername();
	}
	
}
