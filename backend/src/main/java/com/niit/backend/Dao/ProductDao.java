package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.domain.Product;

public interface ProductDao {
public void save(Product product);
public List list();
public List<Product> getProductsByCategory(int cid);
public List<Product> getProductsByCategory(int cid,String pname);
public void delete(Integer id);
}
