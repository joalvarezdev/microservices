package com.joalvarez.inventoryservice.data.dao;

import com.joalvarez.inventoryservice.data.dao.generals.GenericDAO;
import com.joalvarez.inventoryservice.data.models.Inventory;
import com.joalvarez.inventoryservice.data.repository.InventoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InventoryDAO extends GenericDAO<InventoryRepository, Inventory, Long> {

	public InventoryDAO(InventoryRepository repository) {
		super(repository);
	}

	public Optional<Inventory> findBySku(String sku) {
		return this.repository.findBySku(sku);
	}

	public List<Inventory> findBySkuIn(List<String> skus) {
		return this.repository.findBySkuIn(skus);
	}
}
