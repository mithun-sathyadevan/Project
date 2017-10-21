package com.niit.backend;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;
import com.niit.backend.domain.User;

public class TestProductDao {
	@Autowired
	static AnnotationConfigApplicationContext context;
	static CategoryDao categoryDao;
	static SupplierDao supplierDao;
	static ProductDao productDao;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDao= context.getBean(ProductDao.class);
		categoryDao=context.getBean(CategoryDao.class);
	}
	@Test
	public void check() {
		String email="ms111mithun@gmail.com";
		
		
	List<Product> list=productDao.list();
		assertEquals(2,list.size());
		
		
		
	}
}
