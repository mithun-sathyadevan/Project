package com.niit.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;



public class TestCategoryDao {
/*	@Autowired
	static AnnotationConfigApplicationContext context;
	static CategoryDao categoryDao;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDao= context.getBean(CategoryDao.class);
	}
	@Test
	public void check() {
		
		Category category=new Category();
		category.setCname("KFC");

		categoryDao.save(category);
		//productDao.save(product);
		List<Category> list=categoryDao.list();
		assertEquals(3,list.size());
		
		
		
	}*/
}
