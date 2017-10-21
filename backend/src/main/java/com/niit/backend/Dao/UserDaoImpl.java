package com.niit.backend.Dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.domain.User;



@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public void save(User u) {
	/*	System.out.println("inside DAO IMPL/....");
Session session=sessionFactory.getCurrentSession();
		session.save(u);*/
		//sessionFactory.openSession().save(u);
	Session ses=sessionFactory.getCurrentSession();
	ses.beginTransaction();
	ses.save(u);
	ses.getTransaction().commit();
		// TODO Auto-generated method stub
	

	}


public List list() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> Employee=(List) session.createQuery("FROM User").getResultList();
		System.out.println("msiiiii");
		// TODO Auto-generated method stub
		return Employee;
	}
	
	
	public boolean validate(String name, String password) {
		Session session=sessionFactory.openSession();
		boolean userfound=false;
		String sql_query="FROM User as o where o.email=? and o.psw=?";
		Query query=session.createQuery(sql_query);
		query.setParameter(0, name);
		query.setParameter(1, password);
		List<User>list=query.list();
		if((list!=null)&& (list.size()>0))
		{
		userfound=true;
		}
		return userfound;
	}


	public User getById(String email) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		User u=session.get(User.class, email);
		
		return u;
	}
}
