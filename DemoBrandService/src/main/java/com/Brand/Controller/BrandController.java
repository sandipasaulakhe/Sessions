package com.Brand.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Brand.model.Brand;
import com.Brand.model.Product;
import com.Brand.service.BrandService;

@RestController
public class BrandController {

	@Autowired
	private BrandService brandservice;
	
	@Autowired
	private RestTemplate rest;
	
	@GetMapping(value="/{brandname}")
	public Brand getBrand(@PathVariable String brandname)
	{
		Brand b=brandservice.getBrand(brandname);
		List<Product>prodlist=rest.getForObject("http://productservice/"+b.getBid(), List.class);
	b.setProductlist(prodlist);
				return b;
	}
}
