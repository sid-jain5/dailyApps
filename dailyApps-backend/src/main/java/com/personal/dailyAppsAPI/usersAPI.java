package com.personal.dailyAppsAPI;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.dailyAppsModel.Users;

public class usersAPI {

	//all functions will contain try catch block
	//ResponseEntity will be returned in try block
	//ResponseStatusException will be thrown in catch block
	
	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	public ResponseEntity<Users> authenticateUser(@RequestBody Users user)
	{
		return null;
	}
	
	@RequestMapping(value="/userRegister", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody Users user)
	{
		return null;
	}
	
	@RequestMapping(value="/getUsername", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getUsernames()
	{
		return null;
	}
	
	@RequestMapping(value="/getUsername", method=RequestMethod.POST)
	public ResponseEntity<String> deleteUser(@RequestBody Users user)
	{
		return null;
	}
	
}
