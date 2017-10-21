package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;
@Repository
public class CAtegoryDaoImpl implements CategoryDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Category category) {
		Session ses=sessionFactory.getCurrentSession();
		ses.beginTransaction();
		ses.save(category);
		ses.getTransaction().commit();
		ses.close();
		// TODO Auto-generated method stub
		
	}

	public List list() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Category> category=(List) session.createQuery("FROM Category").getResultList();
		session.close();
		// TODO Auto-generated method stub
		return category;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Category category=(Category)session.get(Category.class, id);
		System.out.println("kaaaka");
		System.out.println(category.getCname());
		session.delete(category);
		session.getTransaction().commit();
		session.close();
	}

	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Category category=(Category)session.get(Category.class, id);
		System.out.println("inside");
		session.close();
		return category;
	}

	public void update(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(category);
		session.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

}
