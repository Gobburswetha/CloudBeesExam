package com.example.cbc.demoExam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cbc.demoExam.model.Product;
import com.example.cbc.demoExam.request.BookStoreRequest;
import com.example.cbc.demoExam.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/product/getAll")
	public List<Product> getProductById() {
		return productService.getAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/product/update")
	public ResponseEntity<?> getProductById(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") String id) {
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/product/DiscountOrTax")
	public ResponseEntity<?> getBookPrice(@RequestBody BookStoreRequest bookStoreRequest) {
		return productService.getBookPrice(bookStoreRequest);
	}


}
