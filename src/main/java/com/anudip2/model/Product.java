package com.anudip2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String productname;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="product_cart",joinColumns=@JoinColumn(name="product_id"),inverseJoinColumns=@JoinColumn(name="cart_id"))
    private Set<Cart> carts=new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public Product(int id, String productname, Set<Cart> carts) {
		super();
		this.id = id;
		this.productname = productname;
		this.carts = carts;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
