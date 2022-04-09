package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.DTO.ProductDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "select products.name "
			+ "from products "
			+ "inner join providers on products.id_providers = providers.id "
			+ "where amount >=:min And amount <= :max and providers.name like concat(:beginName, '%')")			
	List <ProductMinProjection> search1(Integer min, Integer max, String beginName);
	
	@Query("select new com.devsuperior.uri2621.DTO.ProductDTO(obj.name) "
			+ "from Product obj "
			+ "where obj.amount >=:min And obj.amount <= :max and obj.provider.name like concat(:beginName, '%')")			
	List <ProductDTO> search2(Integer min, Integer max, String beginName);
}
