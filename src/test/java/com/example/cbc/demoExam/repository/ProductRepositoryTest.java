package com.example.cbc.demoExam.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.cbc.demoExam.model.Product;

@RunWith( MockitoJUnitRunner.class)
public class ProductRepositoryTest {
	
	@Spy
	ProductRepository productRepository;
	
	@Test
	public void addProductTest() 
	{ 
		List<Product> productList = new ArrayList<Product>();
		Product p = new Product();
		p.setProductId("1");
		p.setName("product1");
		p.setDescription("Fictional");
		p.setQuantity(20); 
		p.setPrice(360);
		productList.add(p);
		assertEquals(productRepository.addProduct(p),ResponseEntity.ok(productList));
	  
	 }

}
