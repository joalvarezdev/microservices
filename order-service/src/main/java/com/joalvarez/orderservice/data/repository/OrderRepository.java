package com.joalvarez.orderservice.data.repository;

import com.joalvarez.orderservice.data.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Long countBy();
}
