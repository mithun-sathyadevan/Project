package com.niit.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Config.HibernateConfig;
import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.Dao.UserDaoImpl;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.User;
import java.util.*;
//import antlr.collections.List;

public class Test {
public static void main(String args[]) {
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(HibernateConfig.class);
	CategoryDao  category=ctx.getBean(CategoryDao.class);
	Category cat=new Category();
	cat.setCname("Veg");
	category.save(cat);
	ctx.close();
	//ctx.refresh();
	/*System.out.println(ud);
	User u=new User();
	u.setEmail("ms");
	u.setCity("all");
	u.setName("mjt");
	u.setNumber("77666");
	u.setPsw("pass");
	//u.setPsw("password");
	
	ud.save(u);
	System.out.println("test/////");
	
	//System.out.println(ud.list());
	List<User> list= ud.list();
	Iterator it=list.iterator();
	while(it.hasNext())
		
	{
		User user=(User) it.next();
	System.out.println(user.getName()+user.getNumber());
	}*/
}
}
