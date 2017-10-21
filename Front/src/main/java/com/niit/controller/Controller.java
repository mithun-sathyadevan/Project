package com.niit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Dao.CartDao;
import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.Dao.OrderDao;
import com.niit.backend.Dao.ProductDao;
import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.Dao.UserDao;
import com.niit.backend.domain.Cart;
import com.niit.backend.domain.Order;
import com.niit.backend.domain.Product;
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
	@Autowired
	CartDao cartDao;
	@Autowired
	OrderDao orderDao;

	@RequestMapping(value = { "/home", "/" })
	public String addC(Model m) {

		return "Home";

	}

	@RequestMapping(value = "/ProductList/{cid}")
	public String productList(Model m, @PathVariable("cid") int cid) {

		List<Product> list = new ArrayList();
		System.out.println("inside the list man333");
		list = productDao.getProductsByCategory(cid);
		m.addAttribute("productlist", list);
		System.out.println("inside the list man");
		String str = categoryDao.findById(cid).getCname();
		m.addAttribute("categoryname", str);
		m.addAttribute("cid", cid);
		return "ProductCustomerList";

	}

	@RequestMapping(value = "ProductList/search/{cid}")
	public String Search(Model m, @PathVariable("cid") int cid) {

		List<Product> list = new ArrayList();
		System.out.println("inside the list man333");
		list = productDao.getProductsByCategory(cid);
		m.addAttribute("productlist", list);
		System.out.println("inside the list man");
		String str = categoryDao.findById(cid).getCname();
		m.addAttribute("categoryname", str);
		m.addAttribute("cid", cid);
		return "ProductCustomerList";

	}

	@RequestMapping(value = "/removeCart/{id}/{email}/")
	public String removeCart(@PathVariable("id") Integer id, @PathVariable("email") String email) {
		cartDao.delete(id);
		return "redirect:/ShoppingCart/" + email + "/";
	}

	@RequestMapping("/checkout")
	public ModelAndView checkout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("checkout");
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User u = userDao.getById(userEmail);
		List<Cart> cart = cartDao.listByUser(userEmail);
		System.out.println("poor");
		mav.addObject("user", u);
		mav.addObject("total","cart");
		mav.addObject("cart", cart);

		return mav;

	}

	@RequestMapping(value = "/invoiceprocess", method = RequestMethod.POST)
	public ModelAndView orderSave(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("invoice");
		Order order = new Order();
		int d = Integer.parseInt(request.getParameter("total"));
		String payment = request.getParameter("payment");
		Principal principal = request.getUserPrincipal();
		String email = principal.getName();
		User user = userDao.getById(email);
		order.setPayment(payment);
		order.setUser(user);
		order.setTotal(d);
		orderDao.save(order);
		List<Cart> cartlist = cartDao.listByUser(email);
		for (int i = 0; i < cartlist.size(); i++) {
			cartDao.delete(cartlist.get(i).getCartid());
		}
		mav.addObject("userDetails", user);
		return mav;
	}

	@RequestMapping("checkout1")
	public String checkout() {

		return "redirect:/";

	}

	@RequestMapping(value = "/addCart/{id}/{email}/")
	public String addCart(Model mav,HttpServletRequest request, @PathVariable("id") int id, @PathVariable("email") String email) {
		
		Product product = productDao.getProductById(id);
	
			if(request.getParameter("addbutton")!=null)
			{
			Cart cart = new Cart();

			System.out.println("fdfdfdqq" + product.getName());
			cart.setImage(product.getImage());
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			cart.setUserid(email);
			try {
				cartDao.save(cart);
				return "redirect:/ShoppingCart/" + email + "/";
			} catch (Exception e) {
				e.printStackTrace();
				return "home";
			}
			}
		
			
		
	return "redirect:/";
	
	}
	@RequestMapping(value = "/buyProduct/{id}")
	public String buyProduct(Model m,HttpServletRequest request ,@PathVariable("id") int id) {
		Product product = productDao.getProductById(id);
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		User u = userDao.getById(userEmail);
		List<Cart> cart=cartDao.listByUser("-1");
		System.out.println("Broi this is in");
		
		m.addAttribute("user", u);
		m.addAttribute("total",product.getPrice());
		return "checkout";
		//return "checkout";
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

	/*
	 * @RequestMapping(value = "/productList{cat}") public String
	 * Logout(@PathVariable("cat") int id) { Model m; List<Product> list=new
	 * ArrayList<Product>(); list=productDao.list(); m.addAttribute("productlist",
	 * list);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return "Home";
	 * 
	 * }
	 */

	@RequestMapping(value = "/ShoppingCart/{email}/")
	public String ShoppingCart(Model m, @PathVariable String email) {
		System.out.println(email);
		List<Cart> list = cartDao.listByUser(email);
		m.addAttribute("cartlist", list);
		System.out.println("machaans=" + list.size());
		return "Cart";

	}

	@RequestMapping(value = "/SingleProduct/{id}")
	public String singleDisplay(Model m, @PathVariable("id") int id) {
		Product product = productDao.getProductById(id);
		m.addAttribute("product", product);
		return "SingleProduct";

	}

	@RequestMapping(value = "/Logout1")
	public String Logout() {

		return "Trial";

	}

	/*
	 * @RequestMapping(value = "/insertProduct") public ModelAndView ProductInsert()
	 * { ModelAndView mv=new ModelAndView("ProdInsert"); List<Supplier> list=new
	 * ArrayList<Supplier>(); list=supplierDao.list();
	 * mv.addObject("supplierlist",list); //return "ProdInsert";
	 * 
	 * System.out.println(list+"hai"); return mv; }
	 */

	@RequestMapping(value = "/newRegister")
	public String register(@Valid @ModelAttribute("cmd") User u, BindingResult result) {
		System.out.println(u.getCity());
		try {
			if (result.hasErrors())
				return "Register";
			// boolean m=true;
			u.setEnabled(true);
			u.setRole("role_user");
			userDao.save(u);

			return "Home";
		} catch (Exception e) {
			return "Register";
		}
	}

	@RequestMapping("/error")
	public String errorPage() {
		return "error";

	}

	@RequestMapping("/userLogged")
	public String userLogged() {
		System.out.println("hii");
		return "redirect:/";

	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("catList", categoryDao.list());
	}

}
