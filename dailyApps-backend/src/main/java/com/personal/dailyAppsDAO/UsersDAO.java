package com.personal.dailyAppsDAO;

import java.util.List;

import com.personal.dailyAppsModel.Users;

public interface UsersDAO {

	public Users getUserByUsername(String username) throws Exception;
	public String addUser(Users user) throws Exception; 
	public List<String> getUsernameList() throws Exception;
	public String deleteUser(String username);
	
	//TODO 
	//add additional field to model and entity class of 'email verified -- boolean'
	//add change password functionality
	//add update profile functionality
}
