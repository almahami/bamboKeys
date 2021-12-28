package io.rest.BambooKeys.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.rest.BambooKeys.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Long> {


    @Query("SELECT pr.star_rating,pr.text From productReview pr where ?1=productFK ")
    List<Object[]> findAllByProductId(Long productFK);
    
    @Transactional
    @Modifying
    @Query("DELETE From productReview  where ?1=productFK")
    void deleteAllReviwsByProduct(Long productFK);
    
    @Transactional
    @Modifying
    @Query("DELETE From productReview  where ?1=productFK and ?2= userFK")
    void deleteProductReviewFromUser(Long productFK, Long userFK);
    
}
