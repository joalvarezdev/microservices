package com.joalvarez.productservice.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.productservice.data.dto.ProductDTO;
import com.joalvarez.productservice.data.mapper.generals.BaseMapper;
import com.joalvarez.productservice.data.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, Product> {

	public ProductMapper(ObjectMapper objectMapper) {
		super(objectMapper);
	}
}
