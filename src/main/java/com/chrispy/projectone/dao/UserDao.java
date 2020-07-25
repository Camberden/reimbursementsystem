package com.chrispy.projectone.dao;

import java.util.List;

import com.chrispy.projectone.models.User;

public interface UserDao {
	
	public boolean verifyUserCredentials(String username, String password);
	
	public void registerUser(User user);
	
	public boolean getRole(String username, String password);

	public User getUser(String username, String password);

	public List<String> getUserAsList(String username, String password);
	
	public User translateUser(List<String> listString);


}
