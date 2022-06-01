package com.example.sprintdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "checkOutProducts")
public class CheckOutProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="product_id")
    private Integer productId;
    private Integer qty;
    
    public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@ManyToOne
    @JoinColumn(name = "checkout_id")
    private CheckOutModel checkout;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct() {
		return productId;
	}

	public void setProduct(Integer productId) {
		this.productId = productId;
	}

	public CheckOutModel getCheckout() {
		return checkout;
	}

	public void setCheckout(CheckOutModel checkout) {
		this.checkout = checkout;
	}
}
