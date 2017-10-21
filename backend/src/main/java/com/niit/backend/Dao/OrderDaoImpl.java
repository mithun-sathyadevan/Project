package com.niit.backend.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Order;
import com.niit.backend.domain.Product;
@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	SessionFactory sessionFactory;
	public void save(Order order) {
		Session ses=sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(order);
		ses.getTransaction().commit();
	
		ses.close();
		
	}

}
