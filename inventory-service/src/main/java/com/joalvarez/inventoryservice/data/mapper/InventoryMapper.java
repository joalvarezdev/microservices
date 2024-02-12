package com.joalvarez.inventoryservice.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.inventoryservice.data.dto.InventoryDTO;
import com.joalvarez.inventoryservice.data.mapper.generals.BaseMapper;
import com.joalvarez.inventoryservice.data.models.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper extends BaseMapper<InventoryDTO, Inventory> {

	public InventoryMapper(ObjectMapper objectMapper) {
		super(objectMapper);
	}
}
