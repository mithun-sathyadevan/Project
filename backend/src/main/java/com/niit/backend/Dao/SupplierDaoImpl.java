package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Category;
import com.niit.backend.domain.Supplier;
import com.niit.backend.domain.User;
@Repository
public class SupplierDaoImpl implements SupplierDao{
@Autowired
SessionFactory sessionFactory;

	public void save(Supplier supplier) {
		// TODO Auto-generated method stub
		Session ses=sessionFactory.getCurrentSession();
		ses.beginTransaction();
		ses.save(supplier);
		ses.getTransaction().commit();
	}

	public List<Supplier> list() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Supplier> supplier=(List) session.createQuery("FROM Supplier").getResultList();
		System.out.println("msiiiii");
		session.close();
		// TODO Auto-generated method stub
		return supplier;
	}

	
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Supplier supplier=(Supplier)session.get(Supplier.class, id);
		System.out.println("kaaaka");
		System.out.println(supplier.getSname());
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();
		
	}
	public Supplier findById(Integer id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Supplier supplier=(Supplier)session.get(Supplier.class, id);
		session.close();
		return supplier;
	}

	public void update(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(supplier);
		session.getTransaction().commit();
		
	}

}
