package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.CartDao;
import com.niit.backend.domain.Cart;

public class TestCartDao {
	@Autowired
	static AnnotationConfigApplicationContext context;
	static CartDao cartDao;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDao= context.getBean(CartDao.class);
	}
	@Test
	
	public void check() {
		
	/*	Cart cart=new Cart();
		cart.setImage("profile.jpg");
		cart.setName("Dum biriyani");
		cart.setOrderid(22);
		cart.setPrice(100);
		cart.setQuantity(4);
		cart.setUserid("ms111mithun@gmail.com");
		cartDao.save(cart);*/
		String email="ms111mithun@gmail.com";	
		List<Cart> list=cartDao.listByUser(email);
		System.out.println(list.size());
		//List<Category> list=categoryDao.list();
		assertEquals(1,list.size());
		
		
		
	}
}
