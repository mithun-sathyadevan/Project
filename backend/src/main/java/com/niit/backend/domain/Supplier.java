package com.niit.backend.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Supplier {
@GeneratedValue
@Id
int sid;
String sname;
@OneToMany(mappedBy="supplier",cascade = CascadeType.ALL)
Set<Product> product=new HashSet<Product>();
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}

}
