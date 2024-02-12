package com.joalvarez.orderservice.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.orderservice.data.dto.OrderDTO;
import com.joalvarez.orderservice.data.mapper.generals.BaseMapper;
import com.joalvarez.orderservice.data.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends BaseMapper<OrderDTO, Order> {

	public OrderMapper(ObjectMapper objectMapper) {
		super(objectMapper);
	}

	@Override
	public Order fromDTO(OrderDTO entity) {
		entity.getDetails().forEach(item -> item.setOrderId(entity.getId()));
		return super.fromDTO(entity);
	}
}
