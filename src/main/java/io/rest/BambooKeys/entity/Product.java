package io.rest.BambooKeys.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.rest.BambooKeys.common.BaseEntity;

@Entity
public class Product extends BaseEntity<Long> implements Serializable{
    
    private String productName;
    private String marke;
    private String descrpetion;
    private double price;
    private int amount;
    //@JsonBackReference 
    @JsonIgnore
    @OneToMany(mappedBy = "productFK")
    private List<ProductReview> productReviews;

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
  
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public void setProductReview(ProductReview productReviews) {
        this.productReviews.add( productReviews) ;
    }

    @Override
    public String toString() {
        return "Product [amount=" + amount + ", descrpetion=" + descrpetion + ", marke=" + marke + ", name=" + productName
                + ", price=" + price + "]";
    }

    
    

}
