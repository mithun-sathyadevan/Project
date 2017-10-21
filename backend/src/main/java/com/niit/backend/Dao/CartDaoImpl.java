package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Cart;
import com.niit.backend.domain.Supplier;
@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sessionFactory;
	
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

	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer id) {
		
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Cart cart=(Cart)session.get(Cart.class, id);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();
		
		
	}

	public Cart getCartById(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	public List<Cart> listByUser(String email) {
		List<Cart> c=null;
		Session session=sessionFactory.openSession();
		List<Cart> cartlist=null;
		try{
			session.beginTransaction(); 
			System.out.println("kkkkkkkkkkkkkkkkkkkkkk-----"+email);
			// c=(List<Cart>) session.createSQLQuery("SELECT * FROM CART  where userid=?").setString(0, email).list();
			 List<Cart> list = (List<Cart>) session.createQuery("from Cart where userid =:userid").setString("userid", email).list();
			c=list;
		// c=(List<Cart>) q.setParameter("email", email).getResultList();
			session.getTransaction().commit();
			
			return  c;

		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
				return  null;

		}
	
	}

}
