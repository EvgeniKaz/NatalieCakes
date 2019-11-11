package com.easytech.nataly_cakes.beans;

import com.easytech.nataly_cakes.enums.ProductType;

public class Product {
private ProductType productType;
private String name;
private double price;
private String description;
private long id;
private String image;

public Product() {
	super();
}
public Product(ProductType productType, String name, double price, String description, long id, String image) {
	super();
	this.productType = productType;
	this.name = name;
	this.price = price;
	this.description = description;
	this.id = id;
	this.image = image;
}
public Product(ProductType productType, String name, double price, String description, String image) {
	super();
	this.productType = productType;
	this.name = name;
	this.price = price;
	this.description = description;
	this.image = image;
}
public ProductType getProductType() {
	return productType;
}
public void setProductType(ProductType productType) {
	this.productType = productType;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}



}
