package io.rest.BambooKeys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>  {
    List<Cart> findCartByUserFK(Long userFK);
    

}
    
 
