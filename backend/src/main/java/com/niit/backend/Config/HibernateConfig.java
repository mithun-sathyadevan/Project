package com.niit.backend.Config;

import java.util.Properties;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.backend.domain.Cart;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Order;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;
import com.niit.backend.domain.User;

@Configuration
@ComponentScan(basePackages ={"com.niit"})
@EnableTransactionManagement
public class HibernateConfig {
   @Autowired
	 @Bean(name="dataSource")
	    public DataSource getDataSource()
	    {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:~/test");
	        dataSource.setUsername("mithran");
	        dataSource.setPassword("password");
	        return dataSource;
	    }
	    
	@Bean
    public SessionFactory getSessionFactory()
    {
        
        LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(getDataSource());
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        lsf.addProperties(hibernateProperties);
       // lsf.addAnnotatedClasses(User.class);
        //return lsf.buildSessionFactory();
       Class classes[]={User.class,Category.class,Product.class,Supplier.class,Cart.class,Order.class};
        
        return lsf.addAnnotatedClasses(classes).buildSessionFactory();
    }
    
   
    
	 @Bean
	  public HibernateTransactionManager transactionManager()
	    {
	        HibernateTransactionManager htm = new HibernateTransactionManager();
	        htm.setSessionFactory(getSessionFactory());
	        return htm;
	    }
	 
    
}