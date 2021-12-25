package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>  {
    
}
