package com.joalvarez.orderservice.controller;

import com.joalvarez.orderservice.data.dto.OrderDTO;
import com.joalvarez.orderservice.service.interfaces.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

	private final IOrderService service;

	public OrderController(IOrderService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<OrderDTO> findById(@RequestParam Long id) {
		return ResponseEntity.ok(this.service.findById(id));
	}

	@PostMapping
	public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(dto));
	}
}
