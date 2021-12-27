package io.rest.BambooKeys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class Product extends BaseEntity<Long> implements Serializable{
    
    private String productName;
    private String marke;
    private String descrpetion;
    private double price;
    private int amount;

    public Product() {
    }
    
    public String getName() {
        return productName;
    }
    
    public void setName(String productName) {
        this.productName = productName;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    @Override
    public String toString() {
        return "Product [amount=" + amount + ", descrpetion=" + descrpetion + ", marke=" + marke + ", name=" + productName
                + ", price=" + price + "]";
    }

    
    

}
