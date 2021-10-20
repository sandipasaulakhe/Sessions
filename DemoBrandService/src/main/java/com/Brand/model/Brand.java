package com.Brand.model;

import java.util.ArrayList;
import java.util.List;
public class Brand {
private int bid;
private String brandname;
private List<Product>productlist=new ArrayList<>();


public Brand(int bid, String brandname) {
	super();
	this.bid = bid;
	this.brandname = brandname;
}
@Override
public String toString() {
	return "Brand [bid=" + bid + ", brandname=" + brandname + ", productlist=" + productlist + "]";
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBrandname() {
	return brandname;
}
public void setBrandname(String brandname) {
	this.brandname = brandname;
}
public List<Product> getProductlist() {
	return productlist;
}
public void setProductlist(List<Product> productlist) {
	this.productlist = productlist;
}}
