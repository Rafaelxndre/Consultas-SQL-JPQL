package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "select "
			+ "categories.name, SUM(products.amount) "
			+ "from products "
			+ "inner join categories on products.id_categories = categories.id "
			+ "group by categories.name")
	List<CategorySumProjection> search1();
	
	@Query("select "
			+ " new com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount))"
			+ "from Product obj "
			+ "group by obj.category.name")
	List<CategorySumDTO> search2();
}
