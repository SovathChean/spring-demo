package com.example.sprintdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "checkouts")
public class CheckOutModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<CheckOutProducts> ckProducts=  new ArrayList<>();
	
	public List<CheckOutProducts> getProducts() {
		return ckProducts;
	}
	public void setProducts(List<CheckOutProducts> ckProducts) {
		this.ckProducts = ckProducts;
	}
	public Integer getId() {
		return id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<CheckOutProducts> getCkProducts() {
		return ckProducts;
	}
	public void setCkProducts(List<CheckOutProducts> ckProducts) {
		this.ckProducts = ckProducts;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser() {
		return userId;
	}
	public void setUser(Integer userId) {
		this.userId = userId;
	}
}
