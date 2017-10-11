package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;
import com.niit.backend.domain.User;




//@SessionAttributes("username")
@org.springframework.stereotype.Controller


public class Controller {
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;
	 @RequestMapping(value= {"/home","/"})
	    public String addC(Model m) {
	
	        
	        
	        return "Home";

	    }
	 @RequestMapping(value = "/ProductList/{cid}")
	    public String productList(Model m,@PathVariable("cid") int cid) {
	        
		 
			List<Product> list=new ArrayList();
			System.out.println("inside the list man333");
			list=productDao.getProductsByCategory(cid);
			m.addAttribute("productlist",list);
			System.out.println("inside the list man");
			String str=categoryDao.findById(cid).getCname();
			m.addAttribute("categoryname", str);
			m.addAttribute("cid", cid);
			return "ProductCustomerList";
					

	    }
	 
	 @RequestMapping(value = "ProductList/search/{cid}")
	    public String Search(Model m,@PathVariable("cid") int cid) {
	        
		 
			List<Product> list=new ArrayList();
			System.out.println("inside the list man333");
			list=productDao.getProductsByCategory(cid);
			m.addAttribute("productlist",list);
			System.out.println("inside the list man");
			String str=categoryDao.findById(cid).getCname();
			m.addAttribute("categoryname", str);
			m.addAttribute("cid", cid);
			return "ProductCustomerList";
					

	    }
	 
	 @RequestMapping("/Login")
		public ModelAndView login() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Login");
			return mav;

		}
	 @RequestMapping(value = "/Contact")
	    public String Contact() {
	        
	        
	 
	        return "Contact";

	    }
	 
	 
	 @RequestMapping(value = "/RegisterView")
	    public String Register(Model m) {
	        
		 m.addAttribute("cmd", new User());
	        
	        
	     
	        
	        return "Register";

	    }
	 
	/* @RequestMapping(value = "/productList{cat}")
	    public String Logout(@PathVariable("cat") int id) {
		 Model m;
		 List<Product> list=new ArrayList<Product>();
		 list=productDao.list();
	     m.addAttribute("productlist", list);
	     
		 
	       
	        
	     
	        
	        return "Home";

	    }*/
	 
	
	 
	
	 
	 @RequestMapping(value = "/ShoppingCart")
	    public String ShoppingCart() {
	        
		 
	        return "Cart";

	    }
	 @RequestMapping(value = "/SingleProduct/{id}")
	    public String singleDisplay(Model m,@PathVariable("id") int id) {
	       Product product= productDao.getProductById(id);
	       m.addAttribute("product", product);
	        return "SingleProduct";

	    }
	 
	 
	 
	 @RequestMapping(value = "/Logout1")
	    public String Logout() {
	        
		 
	        return "Trial";

	    }
	 
	/* 
	 @RequestMapping(value = "/insertProduct")
	    public ModelAndView ProductInsert() {
	       ModelAndView mv=new ModelAndView("ProdInsert");
	        List<Supplier> list=new ArrayList<Supplier>();
	        list=supplierDao.list();
	        mv.addObject("supplierlist",list);
	        //return "ProdInsert";
	        
	        System.out.println(list+"hai");
	        return mv;
	    }*/
	 
	 
	 @RequestMapping(value = "/newRegister")
	    public String register(@Valid @ModelAttribute("cmd") User u,BindingResult result) {
	        System.out.println(u.getCity());
	        try
	        {
	        	if(result.hasErrors())
	        		return
	        				"Register";
	    //    	boolean m=true;
	       u.setEnabled(true);
	        	u.setRole("role_user");
	        userDao.save(u);
	        
	        return "Home";
	        }
	        catch(Exception e)
	        {
	        	return "Register";
	        }
	    }
	 
	 
	 
	 
	 @RequestMapping("/error")
		public  String errorPage(){
			return "error";
			
		}
		
		@RequestMapping("/userLogged")
		public  String userLogged(){
			System.out.println("hii");
			return "redirect:/";
			
		}
		@ModelAttribute
		public void addAttributes(Model model) {
		   model.addAttribute("catList", categoryDao.list());
		} 

		

}
