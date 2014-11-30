package com.fcs.dao;

import com.fcs.model.User;

public interface UserDAO {
	public void save(User user);
	public void delete();
}
