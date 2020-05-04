package com.personal.dailyAppsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.dailyAppsDAO.UsersDAO;
import com.personal.dailyAppsModel.Users;
import com.personal.dailyAppsUtility.HashingUtility;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public Users authenticateUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Users userFromDB=usersDAO.getUserByUsername(username);
		
		//Checking if the user exists in database or not
		if(userFromDB == null) {
			throw new Exception("UserService.USER_NOT_FOUND");
		}
		
		//Checking if the password field is null or not
		String passwordFromDB = userFromDB.getHashedPassword();
		if(passwordFromDB==null) {
			throw new Exception("UserService.NULL_PASSWORD");
		}
		
		String hashPassword = HashingUtility.getHashValue(password); // finding the hash value of the entered password 
		
		//Matching if the entered password matches the password stored in database
		if(!hashPassword.equals(passwordFromDB)){
			throw new Exception("UserService.INVALID_PASSWORD");
		}
		
		userFromDB.setPassword(null);
		userFromDB.setHashedPassword(null);
		return userFromDB;
	}

	@Override
	public String addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		
		Users userFromDB = usersDAO.getUserByUsername(user.getUsername());

		if(userFromDB!=null) {
			throw new Exception("UserService.USER_EXISTS");
		}
		
		String hashedPassword = HashingUtility.getHashValue(user.getPassword());
		user.setHashedPassword(hashedPassword);
		
		String usernameFromDAO = usersDAO.addUser(user);
		
		if(!usernameFromDAO.equals(user.getUsername())) {
			throw new Exception("UserService.ERROR");
		}
		
		return "UserService.SUCCESS_MESSAGE"+usernameFromDAO;
	}

	@Override
	public List<String> listUsers() throws Exception {
		// TODO Auto-generated method stub
		List<String> listOfUsers = usersDAO.getUsernameList();
		if(listOfUsers==null || listOfUsers.isEmpty()) {
			throw new Exception("UserService.NO_USERNAME_FOUND");
		}
		return listOfUsers;
	}

	@Override
	public String removeUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Users userFromDB=usersDAO.getUserByUsername(username);
		//Checking if the user exists in database or not
		if(userFromDB == null) {
			throw new Exception("UserService.USER_NOT_FOUND");
		}
		//Checking if the password field is null or not
		String passwordFromDB = userFromDB.getHashedPassword();
		if(passwordFromDB==null) {
			throw new Exception("UserService.NULL_PASSWORD");
		}
		String hashPassword = HashingUtility.getHashValue(password); // finding the hash value of the entered password 
		
		//Matching if the entered password matches the password stored in database
		if(!hashPassword.equals(passwordFromDB)){
			throw new Exception("UserService.INVALID_PASSWORD");
		}	
		return "UserService.DELETE_SUCCESS" + usersDAO.deleteUser(username);
	}
}
