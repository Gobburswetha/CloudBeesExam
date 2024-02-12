package com.example.cbc.demoExam.request;

import java.util.Objects;

public class BookStoreRequest {
	
	public String productId;
	public String discOrTax;
	public double value;
	
	public BookStoreRequest()
	{
		
	}
	
	public BookStoreRequest(String productId, String discOrTax,double value)
	{
		this.productId = productId;
		this.discOrTax = discOrTax;
		this.value = value;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDiscOrTax() {
		return discOrTax;
	}
	public void setDiscOrTax(String discOrTax) {
		this.discOrTax = discOrTax;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		return Objects.hash(discOrTax, productId, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStoreRequest other = (BookStoreRequest) obj;
		return Objects.equals(discOrTax, other.discOrTax) && Objects.equals(productId, other.productId)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	@Override
	public String toString() {
		return "BookStoreRequest [productId=" + productId + ", discOrTax=" + discOrTax + ", value=" + value + "]";
	}

}
