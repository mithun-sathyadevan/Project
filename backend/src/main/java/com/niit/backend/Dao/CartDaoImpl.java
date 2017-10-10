package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Cart;
@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		try {
			Session ses=sessionFactory.getCurrentSession();
			ses.beginTransaction();
			ses.save(cart);
			ses.getTransaction().commit();
			ses.close();
		}
		catch(Exception e)
		{
			System.out.println("exception");
			e.printStackTrace();
		}
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart getCartById(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> list(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
