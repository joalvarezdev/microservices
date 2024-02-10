package com.joalvarez.productservice.data.dao;

import com.joalvarez.productservice.data.dao.generals.GenericDAO;
import com.joalvarez.productservice.data.models.Product;
import com.joalvarez.productservice.data.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO extends GenericDAO<ProductRepository, Product, Long> {

	public ProductDAO(ProductRepository repository) {
		super(repository);
	}
}
