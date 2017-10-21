package com.niit.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
@Id
@GeneratedValue
int oid;
int total;
String payment;
@ManyToOne
@JoinColumn(name="id")
User user;
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}

public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}

public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
