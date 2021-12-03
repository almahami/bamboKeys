package io.rest.BambooKeys.entity;

import javax.persistence.Entity;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class Product extends BaseEntity<Long>{
    
    private String name;
    private String descrpetion;
    private double price;
    
    public Product() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescrpetion() {
        return descrpetion;
    }
    
    public void setDescrpetion(String descrpetion) {
        this.descrpetion = descrpetion;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    

}
