package com.personal.dailyAppsService;

import java.util.List;

import com.personal.dailyAppsModel.Users;

public interface UsersService {
	
	//refer to exceptions in message.properties to throw exception and create new exception in message.property according to need
	
	public Users authenticateUser(String username, String password) throws Exception;
	public String addUser(Users user) throws Exception;
	public List<String> listUsers() throws Exception;
	public String removeUser(String username) throws Exception;//Signature Changed
}
