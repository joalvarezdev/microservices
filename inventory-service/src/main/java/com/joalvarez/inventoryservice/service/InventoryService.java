package com.joalvarez.inventoryservice.service;

import com.joalvarez.inventoryservice.data.dao.InventoryDAO;
import com.joalvarez.inventoryservice.data.dto.BaseWebClientResponse;
import com.joalvarez.inventoryservice.data.dto.InventoryDTO;
import com.joalvarez.inventoryservice.data.dto.ItemRequestInventoryDTO;
import com.joalvarez.inventoryservice.data.mapper.InventoryMapper;
import com.joalvarez.inventoryservice.service.generals.GenericService;
import com.joalvarez.inventoryservice.service.interfaces.IInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class InventoryService extends GenericService<InventoryDAO, InventoryMapper> implements IInventoryService {

	public InventoryService(InventoryDAO inventoryDAO, InventoryMapper mapper) {
		super(inventoryDAO, mapper);
	}

	@Override
	public List<InventoryDTO> findAll() {
		return null;
	}

	@Override
	public InventoryDTO findById(Long id) {
		return null;
	}

	@Override
	public InventoryDTO update(InventoryDTO inventoryDTO) {
		return null;
	}

	@Override
	public InventoryDTO create(InventoryDTO inventoryDTO) {
		return null;
	}

	@Override
	public Boolean isInStock(String sku) {
		var inventory = this.dao.findBySku(sku);

		return inventory.filter(reg -> reg.getQuantity() > 0L).isPresent();
	}

	@Override
	public BaseWebClientResponse areInStock(List<ItemRequestInventoryDTO> items) {
		Map<String, Long> optimizedProducts = new HashMap<>();

        items.forEach(item -> {
			optimizedProducts.merge(item.sku(), item.quantity(), Long::sum);
		});

		var inventories = this.dao.findBySkuIn(optimizedProducts.keySet().stream().toList());

        var errors = new ArrayList<String>();

        optimizedProducts.forEach((sku, quantity) -> {
			var first = inventories.stream().filter(value -> sku.equals(value.getSku())).findFirst();

			if (first.isEmpty()) {
				errors.add("Product with sku ".concat(sku).concat(" does not exist"));
			} else if (first.get().getQuantity() < quantity)  {
				errors.add("Product with sku ".concat(sku).concat(" has insufficient quantity"));
			}

		});

		return new BaseWebClientResponse(errors);
	}
}
