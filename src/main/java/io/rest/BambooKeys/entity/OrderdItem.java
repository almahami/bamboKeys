package io.rest.BambooKeys.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class OrderdItem extends BaseEntity<Long> {
    
    @OneToOne
    private User user;
    @OneToOne 
    private Product product;
    private Long productFK;

    private int quantity;
    

    public OrderdItem() {
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProductFK() {
        return productFK;
    }

    public void setProductFK(Long productFK) {
        this.productFK = productFK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderdItem [product=" + product + ", productFK=" + productFK + ", quantity=" + quantity + ", user="
                + user + "]";
    }

    
    



}
