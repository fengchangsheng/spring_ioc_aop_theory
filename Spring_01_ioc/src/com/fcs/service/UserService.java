package com.fcs.service;

import com.fcs.dao.UserDAO;
import com.fcs.dao.impl.UserDAOImpl;
import com.fcs.model.User;

public class UserService {
	private UserDAO userDAO ;
	
	public void add(User user){
		userDAO.save(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
