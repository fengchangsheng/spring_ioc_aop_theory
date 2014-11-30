package com.fcs.service;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.fcs.aop.LogInterceptor;
import com.fcs.dao.UserDAO;
import com.fcs.dao.impl.UserDAOImpl;
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
	@Test
	public void testProxy(){
		UserDAO userDAO = new UserDAOImpl();
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDAO);
		UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), new Class[]{UserDAO.class} , li);
		userDAOProxy.delete();
		userDAOProxy.save(new User());
	}

}
