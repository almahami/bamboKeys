package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.OrderedItem;

public interface OrderdItemRepository extends JpaRepository<OrderedItem, Long>{
    
}
