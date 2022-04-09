package com.devsuperior.uri2621.DTO;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductDTO {

	private String name;
	
	public ProductDTO() {
		
	}

	public ProductDTO(String name) {
		this.name = name;
	}
	
	public ProductDTO(ProductMinProjection projection) {
		name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + "]";
	}
}
