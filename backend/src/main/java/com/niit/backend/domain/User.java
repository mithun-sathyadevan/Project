package com.niit.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;
@Component
@Entity
public class User {
	String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	String name;
	String number;
	@Id
	@Email(message="user.email.invalid")
	String id;
	String city;
	String password;
	private boolean enabled;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
