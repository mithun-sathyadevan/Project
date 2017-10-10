package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.domain.Category;
import com.niit.backend.domain.Supplier;

public interface SupplierDao {
public void save(Supplier supplier);
public void delete(Integer id);
public List<Supplier> list();
public Supplier findById(Integer id);
}
