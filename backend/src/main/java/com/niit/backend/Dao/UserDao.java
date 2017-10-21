package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.domain.User;


public interface UserDao {
	public void save(User u);
	public List<User> list();
	public boolean validate(String name, String password);
	
	
	public User getById(String email);
}
