package com.niit.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Supplier;

public class TestSuppliersDao {
	/*@Autowired
	static AnnotationConfigApplicationContext context;
	static SupplierDao supplierDao;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDao= context.getBean(SupplierDao.class);
	}
	@Test
	public void check() {
		
		
		
		supplierDao.delete(54);
		List<Supplier> list=supplierDao.list();
		assertEquals(5,list.size());
		
		
		
	}*/

}
