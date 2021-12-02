package io.rest.BambooKeys.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
    
    private String street;
    private String city;
    private int postCode;
    
    public Adress() {
    }

    public Adress(String street, String city, int postCode) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Adress [city=" + city + ", postCode=" + postCode + ", street=" + street + "]";
    }

    
    

}
