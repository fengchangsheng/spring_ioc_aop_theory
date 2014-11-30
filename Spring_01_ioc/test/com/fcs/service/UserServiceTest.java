package com.fcs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fcs.dao.UserDAO;
import com.fcs.model.User;
import com.fcs.spring.BeanFactory;
import com.fcs.spring.ClassPathXMLApplicationContext;
/**
 * @author fcs
 * 模拟spring的依赖注入
 * 2014-10-9
 */
public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		BeanFactory bf = new ClassPathXMLApplicationContext();
		UserService service = (UserService) bf.getBean("userService");
		User u = new User();
		service.add(u);
		
	}

}
