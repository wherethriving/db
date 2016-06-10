package scopa.cona.database.mappers;

import org.apache.ibatis.annotations.Param;
import scopa.cona.database.model.Category;

public interface CategoryMapper {

	Category selectCategoryById(int id);
	void insertCategory(Category category);
	Category selectCategoryDeepById(int id);
	Category selectCategoryDeepById2(int id);
	void insertCategoryProduct(@Param("categoryId") int categoryId, @Param("productId") int productId);
	void updateCategory(Category category);
	void deleteCategory(int id);
}
