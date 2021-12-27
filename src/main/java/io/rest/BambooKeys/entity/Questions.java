package io.rest.BambooKeys.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import io.rest.BambooKeys.common.BaseEntity;
import io.rest.BambooKeys.enum_.Category;

@Entity
public class Questions extends BaseEntity<Long> {
    
    private String subject;
    private String descrpetion;
    @Enumerated
    private Category category;

    @ManyToOne
    private User user;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescrpetion() {
        return descrpetion;
    }

    public void setDescrpetion(String descrpetion) {
        this.descrpetion = descrpetion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questions questionsWitUser(User user){
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Questions [category=" + category + ", descrpetion=" + descrpetion + ", subject=" + subject + ", user="
                + user + "]";
    }
    
    
}
