package com.joalvarez.inventoryservice.data.dto;

import com.joalvarez.inventoryservice.data.dto.generals.BaseDTO;

public record ItemRequestInventoryDTO(String sku, Long quantity) implements BaseDTO {}
