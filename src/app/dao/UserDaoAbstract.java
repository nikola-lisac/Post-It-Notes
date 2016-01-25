package app.dao;

import app.model.User;

public interface UserDaoAbstract {

	public boolean isExisting(String username);
	
	public void addUser(User user);
	
	public User getUser(String username);
}
