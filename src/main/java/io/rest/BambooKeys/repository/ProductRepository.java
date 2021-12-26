package io.rest.BambooKeys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductName(String productName);
    Optional<Product> findByproductNameAndMarke(String productName, String marke);
    List<Product> findAllById(Long productFk);
}
