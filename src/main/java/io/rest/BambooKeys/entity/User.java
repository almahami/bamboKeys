package io.rest.BambooKeys.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.rest.BambooKeys.common.BaseEntity;
import io.rest.BambooKeys.enum_.salutation;

@Entity(name = "user")
public class User extends BaseEntity<Long> implements Serializable{

    private String firstname;
    private String lastname;
    private String e_mail;
    @Embedded
    private Adress adress = new Adress();
    @Enumerated(EnumType.STRING)
    private salutation salutation;
    // @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Questions> questions;
    //@JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "publishers")
    private List<ProductReview> productReviews;
    public User() {
    }

    public User(String firstname, String lastname, String e_mail, Adress adress,
    io.rest.BambooKeys.enum_.salutation salutation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.e_mail = e_mail;
        this.adress = adress;
        this.salutation = salutation;
    }
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(salutation salutation) {
        this.salutation = salutation;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public User addQuestion(Questions question){
        this.questions.add(question);
        return this;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }
    
    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public void addProductReview(ProductReview productReview) {
        this.productReviews.add(productReview);
    }

    @Override
    public String toString() {
        return "User [adress=" + adress + ", e_mail=" + e_mail + ", firstname=" + firstname + ", lastname=" + lastname
                + ", salutation=" + salutation + "]";
    }

    
}


 
