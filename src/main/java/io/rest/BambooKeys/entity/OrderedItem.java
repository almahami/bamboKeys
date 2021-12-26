package io.rest.BambooKeys.entity;



import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
 import javax.persistence.OneToOne;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class OrderedItem extends BaseEntity<Long> {
    

    private Date date;
    private Long  userFK;
    @ManyToMany 
    private List<Product> products = new LinkedList<>();
    private int quantity;
    
    public OrderedItem() {
    }

    public Long getUserFK() {
        return userFK;
    }

    public void setUserFK(Long userFK) {
        this.userFK = userFK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
