package com.joalvarez.orderservice.data.dao;

import com.joalvarez.orderservice.data.dao.generals.GenericDAO;
import com.joalvarez.orderservice.data.models.Order;
import com.joalvarez.orderservice.data.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends GenericDAO<OrderRepository, Order, Long> {

	public OrderDAO(OrderRepository repository) {
		super(repository);
	}

	public Long countBy() {
		return this.repository.countBy();
	}
}
