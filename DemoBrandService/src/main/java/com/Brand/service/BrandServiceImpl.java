package com.Brand.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Brand.model.Brand;

@Service
public class BrandServiceImpl implements BrandService
{
List<Brand> brandlist = Arrays.asList(new Brand(1,"sony"),
									new Brand(2,"samsung"),new Brand(3,"LG"));
public Brand getBrand(String brandname)
{
	for(Brand b:brandlist)
		{
		if(b.getBrandname().equalsIgnoreCase(brandname))
			return b;
		}
	return null;
	}
}
