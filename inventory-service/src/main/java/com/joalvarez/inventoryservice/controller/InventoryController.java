package com.joalvarez.inventoryservice.controller;

import com.joalvarez.inventoryservice.data.dto.BaseWebClientResponse;
import com.joalvarez.inventoryservice.data.dto.ItemRequestInventoryDTO;
import com.joalvarez.inventoryservice.service.interfaces.IInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InventoryController {

	private final IInventoryService service;

	public InventoryController(IInventoryService service) {
		this.service = service;
	}

	@GetMapping("{sku}")
	public ResponseEntity<Boolean> isInStock(@RequestParam String sku) {
		return ResponseEntity.ok(this.service.isInStock(sku));
	}

	@PostMapping("in-stock")
	public ResponseEntity<BaseWebClientResponse> areInStock(@RequestBody List<ItemRequestInventoryDTO> items) {
		return ResponseEntity.ok(this.service.areInStock(items));
	}
}
