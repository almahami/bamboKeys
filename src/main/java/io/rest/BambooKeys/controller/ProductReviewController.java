package io.rest.BambooKeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.ProductReview;
import io.rest.BambooKeys.service.ProductReviewService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductReviewController {
    
    @Autowired
    private ProductReviewService productReviewService;

    //!!! Getting null values
    @PostMapping("/addReviw/{userFK}/{productFK}")
    public ProductReview addProductReview(@RequestBody ProductReview productReview, @PathVariable Long userFK, @PathVariable Long productFK){
        //ProductReview pr  = new ProductReview();
        //pr.setStar_rating(productReview.getStar_rating());
        //pr.setText(productReview.getText());
        
        return productReviewService.addProductReview(productReview, productFK, userFK);
    }

    @GetMapping("/getProductsReview/{productFK}")
    public List<Object[]> getProductReviews(@PathVariable Long productFK){
        return productReviewService.getProductsReviws(productFK);
    }

    @DeleteMapping("deleteAllReviewsByProduct/{productFK}")
    public void deleteAllReviewsByProduct(@PathVariable Long productFK){
        productReviewService.deleteALLProductReviews(productFK);
    }

    @DeleteMapping("deleteAllReviewsByProduct/{productFK}/{userFK}")
    public void deleteProductReviewFromUser(@PathVariable Long productFK, @PathVariable Long userFK){
        productReviewService.deleteProductReviewFromUser(productFK, userFK);
    }
    
    @PutMapping("/editReview/{reviewId}")
    public ProductReview editReview( @RequestBody ProductReview nproductReview, @PathVariable Long reviewId){
        ProductReview pr  = new ProductReview();
        pr.setStar_rating(nproductReview.getStar_rating());
        pr.setText(nproductReview.getText());
        return productReviewService.editReview(reviewId, nproductReview);
    }
    
}
