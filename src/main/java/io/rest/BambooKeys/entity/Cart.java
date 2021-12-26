package io.rest.BambooKeys.entity;

import javax.persistence.Entity;
import io.rest.BambooKeys.common.BaseEntity;

@Entity(name = "cart")
public class Cart extends BaseEntity<Long> {

    private Long userFK;
    private Long productFK;
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
        return productFK;
    }

    public void setProductFK(Long productFK) {
       this.productFK = productFK;
    }

}
