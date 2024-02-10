package com.joalvarez.productservice.controller;

import com.joalvarez.productservice.data.dto.ProductDTO;
import com.joalvarez.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}
}