package com.joalvarez.orderservice.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.orderservice.data.dto.ItemDTO;
import com.joalvarez.orderservice.data.mapper.generals.BaseMapper;
import com.joalvarez.orderservice.data.models.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper extends BaseMapper<ItemDTO, Item> {

	public ItemMapper(ObjectMapper objectMapper) {
		super(objectMapper);
	}
}
