package com.niit.backend;

import static org.junit.Assert.assertEquals;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Config.HibernateConfig;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.Dao.UserDaoImpl;
import com.niit.backend.domain.User;

public class TestUserDao {

	@Autowired
	static AnnotationConfigApplicationContext context;
	static UserDao userDao;
	
	
	@BeforeClass
	public static void initialize() {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao= context.getBean(UserDao.class);
	}
	
	
	@Test
	public void check() {
		User u=new User();
		u.setEnabled(true);
		u.setRole("ROLE_USER");
		u.setName("krishna2");
		u.setCity("bangalore");
		u.setNumber("4577777");
		u.setPassword("p");
		u.setId("ms111mithu@gmail.com");
		u.setEnabled(true);
		userDao.save(u);
		
		assertEquals(u.getName(),u.getName());
		
		
		
	}
}
