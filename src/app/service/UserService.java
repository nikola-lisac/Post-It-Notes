package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.dao.UserDao;
import app.dao.UserDaoAbstract;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDaoAbstract userDao;
	
	public boolean isExisting(String username) {
		return userDao.isExisting(username);
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public User getUser(String username){
		return userDao.getUser(username);
	}

}
