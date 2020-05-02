package com.personal.dailyAppsDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.dailyAppsEntity.UserEntity;
import com.personal.dailyAppsModel.Users;

public class UsersDAOImpl implements UsersDAO{

	
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
	}

	@Override
	public List<String> getUsernameList() throws Exception {
		// TODO Auto-generated method stub
		Query q = entityManager.createQuery("SELECT u.username from UserEntity u");
		List<String> usernameList = q.getResultList();
		return usernameList;
	}

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity=entityManager.find(UserEntity.class,username);
		entityManager.remove(userEntity);
		return userEntity.getUsername();
	}
	
}
