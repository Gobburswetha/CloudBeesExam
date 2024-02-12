package com.example.cbc.demoExam.model;

import java.util.Objects;

public class Product {

	private String productId;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Product()
	{
		
	}
	
	public Product(String productId, String name, String description, double price, int quantity)
	{
		this.productId = productId;
		this.name = name ;
		this.description =description;
		this.price = price;
		this.quantity= quantity;
		
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, name, price, productId, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productId, other.productId) && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
}
