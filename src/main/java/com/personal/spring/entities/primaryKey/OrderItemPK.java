package com.personal.spring.entities.primaryKey;

import java.io.Serializable;
import java.util.Objects;

import com.personal.spring.entities.Order;
import com.personal.spring.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class OrderItemPK implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "fk_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "fk_order")
	private Order order;
	
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
		

}
