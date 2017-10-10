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
	/*@Autowired
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
		Category category=new Category();
		category.setCname("KFC");
		category.setCid(2);
		Supplier supplier=new Supplier();
		supplier.setSname("kFC");
		supplier.setSid(3);
		//categoryDao.save(category);
		
		Product product=new Product();
		
		//product.setCategory("vegetable");
		product.setDetails("hathismithun");
		product.setColor("green");
		//product.setFlag(true);
		product.setName("Pizza veg");
		product.setQuantity(9);
		product.setPrice(200);
		product.setSupplier(supplier);
		product.setCategory(category);
		//category.getProduct().add(product);
		
	File file=new File("/home/mithun/eclipse-workspace/Front/src/main/webapp/resources/images/1.jpg");
		
		byte[] bFile = new byte[(int) file.length()];
		
		 
	
		        try {
		
		         FileInputStream fileInputStream = new FileInputStream(file);
		
		         fileInputStream.read(bFile);
		
		         fileInputStream.close();
		
		        } catch (Exception e) {
		
		         e.printStackTrace();
		
		        }

		
		
		product.setImage(bFile);
		
	
		//categoryDao.save(category);
		productDao.save(product);
	//	List<Product> list=productDao.list();
		assertEquals(product.getName(),product.getName());
		
		
		
	}*/
}
