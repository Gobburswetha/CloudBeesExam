package com.example.cbc.demoExam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cbc.demoExam.model.Product;
import com.example.cbc.demoExam.repository.ProductRepository;
import com.example.cbc.demoExam.request.BookStoreRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ResponseEntity<?> addProduct(Product product)
	{
		return productRepository.addProduct(product);
	}
	public List<Product> getAll()
	{
		return productRepository.getAll();
	}
	public ResponseEntity<?> getProductById(String id)
	{
		return productRepository.getProductById(id);
	}
	public ResponseEntity<?> updateProduct(Product product)
	{
		return productRepository.updateProduct(product);
	}
	public String deleteProduct(String id)
	{
		return productRepository.deleteProduct(id);
	}
	
	public ResponseEntity<?> getBookPrice(BookStoreRequest bookStoreRequest) {
		return productRepository.getBookPrice(bookStoreRequest);
	}

}
