package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.domain.Category;


public interface CategoryDao {
	public void save(Category category);
	public List list();
	public void delete(Integer id);
	public Category findById(Integer id);
	public void update(Category category);
}
