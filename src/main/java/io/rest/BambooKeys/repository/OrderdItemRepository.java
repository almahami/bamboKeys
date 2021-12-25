package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.OrderdItem;

public interface OrderdItemRepository extends JpaRepository<OrderdItem, Long>{
    
}
