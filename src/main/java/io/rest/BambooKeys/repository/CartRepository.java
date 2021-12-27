package io.rest.BambooKeys.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.rest.BambooKeys.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>  {
    
    List<Cart> findCartByUserFK(Long userFK);
    
    @Query("SELECT productFK FROM cart WHERE ?1 = userFK")
    List<Long> getProductsByUserFK(Long userFK);
    
    @Query("SELECT userFK FROM cart  where ?1 = userFK")
    Optional<Long> searchCartWithUserFK(Long userFK);
    
    @Query("SELECT quantity FROM cart  where ?1 = productFK and ?2= userFK")
    int getQuantityForProduct(Long productFK, Long userFK);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM cart WHERE ?1 = productFK and ?2 = userFK")
    void deleteProductFromCart(Long productFK, Long userFK);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM cart WHERE ?1 = userFK")
    void deleteCartByUserFK(Long userFK);
    

}
    
 
