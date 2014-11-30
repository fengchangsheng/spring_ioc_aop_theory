package com.fcs.dao.impl;

import com.fcs.dao.UserDAO;
import com.fcs.model.User;
/**
 * 
 * @author fcs
 * 模拟AOP
 * 2014-10-12
 */
public class UserDAOImpl implements UserDAO{

	@Override
	public void save(User user) {
		System.out.println("a user saved!");
	}

	@Override
	public void delete() {
		System.out.println("a user deleted");
	}

}
