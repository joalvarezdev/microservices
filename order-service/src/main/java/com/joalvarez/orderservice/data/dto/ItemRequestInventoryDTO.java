package com.joalvarez.orderservice.data.dto;

import com.joalvarez.orderservice.data.dto.generals.BaseDTO;

public record ItemRequestInventoryDTO(String sku, Long quantity) implements BaseDTO {}
