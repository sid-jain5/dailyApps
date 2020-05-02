package com.personal.dailyAppsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.dailyAppsDAO.UsersDAO;
import com.personal.dailyAppsModel.Users;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public Users authenticateUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Users users=usersDAO.getUserByUsername(username);
		if(users.getPassword()==password)
		return users;
		return null;
	}

	@Override
	public String addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		
		return usersDAO.addUser(user);
	}

	@Override
	public List<String> listUsers() throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.getUsernameList();
	}

	@Override
	public String removeUser(String username) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.deleteUser(username);
	}

}
