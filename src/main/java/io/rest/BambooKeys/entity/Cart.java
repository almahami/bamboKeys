package io.rest.BambooKeys.entity;


import javax.persistence.Entity;

import javax.persistence.OneToOne;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class Cart extends BaseEntity<Long> {

    private Long userFK;
    private Long ProductFK;
    private int quantity;
    
   
   
    public Cart(){

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getUserFK() {
        return userFK;
    }

    public void setUserFK(Long userFK) {
        this.userFK = userFK;
    }

    public Long getProductFK() {
        return ProductFK;
    }

    public void setProductFK(Long productFK) {
        ProductFK = productFK;
    }

   


}
