package com.joalvarez.inventoryservice.utils;

import com.joalvarez.inventoryservice.data.models.Inventory;
import com.joalvarez.inventoryservice.data.repository.InventoryRepository;
import com.joalvarez.inventoryservice.shared.HasLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner, HasLogger {

	private final InventoryRepository repository;

	public DataLoader(InventoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.info("Loading data ....");
		if (this.repository.findAll().isEmpty()) {
			this.repository.saveAll(List.of(
				new Inventory("0001", 23L)
			));
		}
	}
}
