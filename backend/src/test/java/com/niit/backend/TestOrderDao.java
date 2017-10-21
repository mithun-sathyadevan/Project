package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.OrderDao;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.domain.Order;
import com.niit.backend.domain.User;

public class TestOrderDao {
	@Autowired
	static AnnotationConfigApplicationContext context;
	static OrderDao orderDao;
	@Autowired
	static UserDao userDao;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDao= context.getBean(OrderDao.class);
	}
	@Test
	
	public void check() {
		
		Order order=new Order();
		order.setPayment("net bank");
		order.setTotal(220);
		User user=userDao.getById("ms111mithun@gmail.com");
		
		orderDao.save(order);
		
		assertEquals(order.getPayment(),order.getPayment());
		
		
		
	}
}
