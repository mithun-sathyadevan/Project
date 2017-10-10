package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;


@Controller
public class AdminController {
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") int id) {

        supplierDao.delete(id);
        return "redirect:/Admin";
     ///   return "ProdInsert";

    }
	@RequestMapping(value="/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) {

       productDao.delete(id);
        return "redirect:/Admin";
     ///   return "ProdInsert";

    }
	
	
	@RequestMapping(value = "/addSupplier")
    public String addSupplier(@ModelAttribute("cmd") Category category,@ModelAttribute("cmd1") Supplier supplier,@ModelAttribute("product") Product product) {
        try {
        	supplierDao.save(supplier);
        	System.out.println("hiii");
        }
        catch(Exception e)
        {
        	
        }
        return "redirect:/Admin";
        

    }
	
	@RequestMapping(value = {"/Admin"})
    public String Admin(Model m) {
        
	 m.addAttribute("cmd", new Category());
        
     m.addAttribute("cmd1", new Supplier())  ; 
  
     List<Category> listc=new ArrayList<Category>();
     listc=categoryDao.list();
     m.addAttribute("categorylist", listc);
        List<Supplier> list=new ArrayList<Supplier>();
        list=supplierDao.list();
        m.addAttribute("supplierlist",list); 
        List<Product> listp=new ArrayList();
        listp=productDao.list();
        System.out.println(listp.size()+"mithru");
        m.addAttribute("productlist",listp);
        return "ProdInsert";

    }
	
	
	 @RequestMapping(value = "/addCategory")
	    public String addCategory(@ModelAttribute("cmd") Category category,@ModelAttribute("cmd1") Supplier supplier,@ModelAttribute("product") Product product) {
	        try {
	        	categoryDao.save(category);
	        	System.out.println("hiii");
	        }
	        catch(Exception e)
	        {
	        	
	        }
	        return "redirect:/Admin";
	        

	    }
	 @RequestMapping(value="/deleteCategory/{id}")
	    public String deleteCategory(@PathVariable("id") int id) {

	        categoryDao.delete(id);
	        return "redirect:/Admin";
	     ///   return "ProdInsert";

	    }
	 
	 
	 @RequestMapping(value = "/addProduct")
	    public String addProduct(HttpServletRequest request, @ModelAttribute("cmd") Category category,@ModelAttribute("cmd1") Supplier supplier,@RequestParam("image") MultipartFile uploadFile) {
	          	Product product=new Product();
	        	product.setDetails(request.getParameter("details"));
	        	product.setColor(request.getParameter("color"));
	        	product.setName(request.getParameter("name"));
	        	product.setPrice(Integer.parseInt(request.getParameter("price")));
	        	
	        	product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	       
	        	String filepath=request.getSession().getServletContext().getRealPath("/");
	        	String filename=uploadFile.getOriginalFilename();
	        	product.setImage(filename);
	        	category=categoryDao.findById(Integer.parseInt(request.getParameter("category")));
	        	product.setCategory(category);
	        	product.setSupplier(supplierDao.findById(Integer.parseInt(request.getParameter("supplier"))));
	     
	        	System.out.println("filepath    -------------------"+filepath+"     "+filename);
	        	
	        	productDao.save(product);
	        	try
	        	{
	        	byte imagebyte[]=uploadFile.getBytes();
	        	File file=new File(filepath+"/resources/images/"+filename);
	        	uploadFile.transferTo(file);
	        	BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/images/"+filename));
	        	fos.write(imagebyte);
	        	fos.close();
	        	  return "redirect:/Admin";
	        	}
	         catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	     
	        return "ProdInsert";
	        

	 }
	 @ModelAttribute
		public void addAttributes(Model model) {
		   model.addAttribute("catList", categoryDao.list());
		} 
}
