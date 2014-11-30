package com.fcs.dao.impl;

import com.fcs.dao.UserDAO;
import com.fcs.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void save(User user) {
		System.out.println("a user saved!");
	}

}
