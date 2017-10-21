package com.niit.backend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;
import com.niit.backend.domain.User;

@Repository
public class ProductDaoImpl implements ProductDao{
@Autowired
SessionFactory sessionFactory;
	
	public void save(Product product) {
		System.out.println("hi");
		Session ses=sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(product);
		ses.getTransaction().commit();
		System.out.println("hi");
		ses.close();
		// TODO Auto-generated method stub
		
	}

	public List list() {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Product> product=(List) session.createQuery("FROM Product").getResultList();
		System.out.println("msiiiii");
		session.close();
		return product;
	}

	public List<Product> getProductsByCategory(int cid) {
		Session session=sessionFactory.openSession();
		List<Product> products =null;
		session.beginTransaction();
		products= session.createQuery("from Product where category_cid="+cid).list();   
		session.getTransaction().commit();
		 return products;
		}

	
	public List<Product> getProductsByCategory(int cid, String pname) {
	/*	Session session=sessionFactory.openSession();
		List<Product> products =null;
		session.beginTransaction();
		products= session.createQuery("from Product where category_cid="+cid "and name="+pname).list();   
		session.getTransaction().commit();
		 return products;*/
		return null;
	}

	
	public void delete(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product product=(Product)session.get(Product.class, id);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
		
	}

	public Product getProductById(int id) {
		Session session=sessionFactory.openSession();
		Product product =null;
		session.beginTransaction();
		product= (Product) session.createQuery("from Product where id="+id).uniqueResult();   
		session.getTransaction().commit();
		 return product;
	}

	@Override
	public void update(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(product);
		session.getTransaction().commit();
		
	}
	

}
