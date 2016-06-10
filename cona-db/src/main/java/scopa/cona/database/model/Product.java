package scopa.cona.database.model;

public class Product {
	
	private int productId;
	private String productName;
	
	public Product(){}
	
	public Product(String name){
		productName = name;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
