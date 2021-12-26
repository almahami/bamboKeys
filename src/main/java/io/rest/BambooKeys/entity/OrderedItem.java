package io.rest.BambooKeys.entity;



import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class OrderedItem extends BaseEntity<Long> {
    
    @OneToOne
    @JoinColumn(name="userFK")
    private User user;
    @OneToOne 
    private Cart cart;
    
   

    private int quantity;
    

    public OrderedItem() {
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

   

    
    



}
