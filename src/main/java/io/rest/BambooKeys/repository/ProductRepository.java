package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
