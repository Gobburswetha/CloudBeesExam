package com.example.cbc.demoExam.response;

import java.util.Objects;

import com.example.cbc.demoExam.model.Product;

public class BookStoreResponse {
	
	public String message;
	public Product product;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStoreResponse other = (BookStoreResponse) obj;
		return Objects.equals(message, other.message) && Objects.equals(product, other.product);
	}
	@Override
	public String toString() {
		return "BookStoreResponse [message=" + message + ", product=" + product + "]";
	}

}
