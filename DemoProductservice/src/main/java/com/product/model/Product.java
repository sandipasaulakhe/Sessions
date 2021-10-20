package com.product.model;

public class Product {
	private int productid;
	private String productname;
	private int price;
	private int brandid;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	
	public Product(int productid, String productname, int price, int brandid) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.brandid = brandid;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", price=" + price + ", brandid="
				+ brandid + "]";
	}
	

}
