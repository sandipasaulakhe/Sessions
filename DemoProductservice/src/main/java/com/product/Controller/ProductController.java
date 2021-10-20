package com.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.Productservice;

@RestController
public class ProductController
{
	@Autowired
	private Productservice pserv;
	
	
	

	@GetMapping(value="/{brandid}")
	public List<Product>getProductByBrandid(@PathVariable int brandid)
	{
		
		return pserv.getProductByid(brandid);
	}
	
		
}
