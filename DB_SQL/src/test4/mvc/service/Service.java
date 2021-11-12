package test4.mvc.service;

import java.util.Vector;

import test4.mvc.dto.Product;

public interface Service {

	void addProduct();//insert
	
	void editProduct();
	
	void delProduct();
	
	Product getProduct();//select one
	
	Vector<Product> getProducts();
}
