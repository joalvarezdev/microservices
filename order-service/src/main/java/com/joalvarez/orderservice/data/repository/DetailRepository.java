package com.joalvarez.orderservice.data.repository;

import com.joalvarez.orderservice.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Item, Long> {
}
