package io.rest.BambooKeys.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.rest.BambooKeys.common.BaseEntity;

@Entity(name = "productReview")
public class ProductReview extends BaseEntity<Long> {
  
    //@JsonManagedReference 
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userFK")
    private User publishers;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productFK")
    private Product product;
    private String star_rating;
    private Date date;
    private String text;
    
    public ProductReview(){

    }
    
    public User getPublishers() {
        return publishers;
    }

    public void setPublishers(User publishers) {
        this.publishers = publishers;
    }

    public String getStar_rating() {
        return star_rating;
    }
    
    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductReview [publishers=" + publishers + ", star_rating=" + star_rating + ", text=" + text + "]";
    }

    

}
