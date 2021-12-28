package io.rest.BambooKeys.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.ProductReview;
import io.rest.BambooKeys.repository.ProductReviewRepository;

@Service
public class ProductReviewService {
    private Logger log;
    @Autowired
    private ProductReviewRepository productReviewRepository;
    @Autowired 
    private ProductService productService;
    @Autowired
    private UserService userService;

    public ProductReviewService(Logger log){
        this.log=log;
    }

    public ProductReview addProductReview(ProductReview productReview, Long productFK, Long userFK){
        if(userService.isUserExisist(userFK) && productService.exsistingProduct(productFK)){
            log.info("the user with id: " + userFK + "add Reviw for the Product: " + productFK + "Reviw:::" + productReview.toString());
            return  productReviewRepository.save(productReview);
        }
        return  null;
    }

    public List<Object[]> getProductsReviws(Long productFK){
        if(productService.exsistingProduct(productFK)){
            log.info("List all Reviews" + productReviewRepository.findAllByProductId(productFK));
            return productReviewRepository.findAllByProductId(productFK);
        } 
        return null;
    }

    public void deleteALLProductReviews(Long productFK){
        if(productService.exsistingProduct(productFK)){
            log.warn("Delete All Reviews for Product " + productFK);
            productReviewRepository.deleteAllReviwsByProduct(productFK);
        } 
    }

    public void deleteProductReviewFromUser(Long productFK, Long userFK){
        if(productService.exsistingProduct(productFK) && userService.isUserExisist(userFK)){
            log.warn("Delete the  Reviews  for Product " + productFK + "from user" + userFK);
            productReviewRepository.deleteProductReviewFromUser(productFK, userFK);
        }
    }

    public ProductReview editReview(Long reviewId, ProductReview nproductReview){
        return productReviewRepository.findById(reviewId)
        .map(productReview -> {
            log.info("old review" + productReviewRepository.findById(reviewId).get());
            productReview.setText(nproductReview.getText());
            productReview.setDate(new Date());
            return productReviewRepository.save(productReview);
    })
    
    .orElseThrow( () -> new RuntimeException("THE REVIEW DOES NOT FOUND; ID " + reviewId));
    }
    
}