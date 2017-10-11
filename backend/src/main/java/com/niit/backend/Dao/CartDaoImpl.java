package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Cart;
import com.niit.backend.domain.Supplier;
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
	public void delete(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Cart cart=(Cart)session.get(Cart.class, id);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public Cart getCartById(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> list(String email) {
		 
		Session session=sessionFactory.openSession();
		List<Cart> cartlist=null;
		try{
			session.beginTransaction();
		 /*p=	session.get(CartModel.class, userId);*/
		/*p=	(CartModel) session.createQuery("from CartModel where userMailId="+userId).uniqueResult();*/
		
		cartlist=	(List<Cart>) session.createQuery(" from Cart  where userid ="+email).list();
				session.getTransaction().commit();
			
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return  cartlist;
	
	}

}
