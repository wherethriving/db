package scopa.cona.database.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int categoryId;
	
	private String categoryName;

	private List<Product> products;
	
	public Category(){
		products = new ArrayList<Product>();
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}	
	
	public void addProduct(Product product){
		if (products == null)
			products = new ArrayList<Product>();
		products.add(product);
	}

}
