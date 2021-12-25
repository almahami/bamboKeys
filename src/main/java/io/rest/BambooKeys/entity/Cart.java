package io.rest.BambooKeys.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class Cart extends BaseEntity<Long> {

    private int quanty;
    @OneToMany
    private List<Product> items = new LinkedList<>();
    //** Only PERSIST, because we want to keep customer data in db when deleting cart
    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    public Cart(){

    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public int getQuanty() {
        return quanty;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
