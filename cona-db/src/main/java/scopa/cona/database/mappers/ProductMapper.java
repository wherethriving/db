package scopa.cona.database.mappers;


import scopa.cona.database.model.Product;

public interface ProductMapper {
	public Product selectProductById(int id);
	public void insertProduct(Product product);
}
