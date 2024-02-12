package com.example.cbc.demoExam.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.cbc.demoExam.model.Product;
import com.example.cbc.demoExam.request.BookStoreRequest;
import com.example.cbc.demoExam.response.BookStoreResponse;

@Repository
public class ProductRepository {
	
	public List<Product> productList = new ArrayList<Product>();

	public ResponseEntity<?> addProduct(Product product)
	{
		if(product.getProductId()!=null)
		{
			productList.add(product);
			return ResponseEntity.ok(productList);
		}
		else
			return ResponseEntity.badRequest().body("Error in Adding product");
	}
	
	public ResponseEntity<?> getProductById(String id) {
		Product response = productList.stream().filter(p-> p.getProductId().equals(id)).findFirst().get();
		if(response!=null)
		{
			return ResponseEntity.ok(response);
		}
		else
		{
			return ResponseEntity.badRequest().body("Product is not available in list");
		}
	}

	public ResponseEntity<?> updateProduct(Product product) {
		
		Product response = productList.stream().filter(p-> p.getProductId().equals(product.getProductId())).findFirst().get();
		if(response!=null && response.getProductId()!=null)
		{
			productList.set(Integer.parseInt(product.getProductId())-1, product);
			return ResponseEntity.ok("Sucessfully Updated Product");
		}
		else
			return ResponseEntity.badRequest().body("Error in Updating Product");
	}
	
	public String deleteProduct(String id) {
		Product response = productList.stream().filter(p-> p.getProductId().equals(id)).findFirst().get();
		if(response.getProductId()!=null)
		{
			productList.removeIf(pr -> pr.getProductId().equals(id));
			return "Deleted Product from product list";
		}
		else
			return "Product is not available in list";
	
	}

	public List<Product> getAll() {
		return productList;
	}

	public ResponseEntity<?> getBookPrice(BookStoreRequest bookStoreRequest) {
		
		BookStoreResponse bookStoreResponse = new BookStoreResponse();
		List<Product> bookProducts = this.getAll();
		if(bookStoreRequest.getProductId()!=null)
		{
			Product booksList = bookProducts.stream().filter(p-> p.getProductId().equalsIgnoreCase(bookStoreRequest.getProductId())).findFirst().get();
			if(booksList!=null && booksList.getProductId()!=null)
			{
				String discOrTax = bookStoreRequest.getDiscOrTax();
				double value = bookStoreRequest.getValue();
				double totalPrice = 0;
				if(discOrTax.equals("DISCOUNT"))
				{
					totalPrice = booksList.getPrice()-((value/100)*booksList.getPrice());
					System.out.print("discount {}"+totalPrice);
				}
				else if(discOrTax.equals("TAX"))
				{
					totalPrice = booksList.getPrice()+((value/100)*booksList.getPrice());
					System.out.print("tax {}"+totalPrice);
				}
				booksList.setPrice(totalPrice);
				bookStoreResponse.setMessage("Succesfully Updated Product Details");
				bookStoreResponse.setProduct(booksList);
				return ResponseEntity.ok(bookStoreResponse);
			}
		}
		else
			return ResponseEntity.badRequest().body("Error in Adding product");
		return null;
	}

}
