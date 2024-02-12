package com.joalvarez.inventoryservice.data.repository;

import com.joalvarez.inventoryservice.data.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySku(String sku);
	List<Inventory> findBySkuIn(List<String> skus);
}
