package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.domain.Cart;

public interface CartDao {
	public void save(Cart cart);
	public void updateCart(Cart cart);
	public void delete(Cart cart);
	public Cart getCartById(int cart_id);
	public List<Cart> list(String username);
}