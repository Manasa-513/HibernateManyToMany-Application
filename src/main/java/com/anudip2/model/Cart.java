package com.anudip2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart 
{
	@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String items;
    @ManyToMany(mappedBy="carts",fetch=FetchType.EAGER)
    private Set<Product> carts=new HashSet();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Set<Product> getCarts() {
		return carts;
	}
	public void setCarts(Set<Product> carts) {
		this.carts = carts;
	}
	public Cart(int id, String items, Set<Product> carts) {
		super();
		this.id = id;
		this.items = items;
		this.carts = carts;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
