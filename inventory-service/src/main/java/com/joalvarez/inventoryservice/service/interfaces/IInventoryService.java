package com.joalvarez.inventoryservice.service.interfaces;

import com.joalvarez.inventoryservice.data.dto.BaseWebClientResponse;
import com.joalvarez.inventoryservice.data.dto.InventoryDTO;
import com.joalvarez.inventoryservice.data.dto.ItemRequestInventoryDTO;
import com.joalvarez.inventoryservice.service.generals.IBaseService;

import java.util.List;

public interface IInventoryService extends IBaseService<InventoryDTO, Long> {
	Boolean isInStock(String sku);

	BaseWebClientResponse areInStock(List<ItemRequestInventoryDTO> items);
}
