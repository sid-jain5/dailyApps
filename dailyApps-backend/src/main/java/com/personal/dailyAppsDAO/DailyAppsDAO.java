package com.personal.dailyAppsDAO;

public interface DailyAppsDAO {

	public boolean authenticateUser(String emailId, String password);
	public String getHashCode(String emailId);
}
