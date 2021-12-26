package io.rest.BambooKeys.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.rest.BambooKeys.common.BaseEntity;

@Entity(name = "ordered")
public class Ordered  extends BaseEntity<Long>{
    
    private int numberOfItems;
    private Long userFK;
    private Date date;
    @OneToMany
    private List<OrderedItem> ordereditems;
    
    
    public Ordered (){
        ordereditems= new LinkedList<>();
        numberOfItems=0;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Long getUserFK() {
        return userFK;
    }

    public void setUserFK(Long userFK) {
        this.userFK = userFK;
    }

    public List<OrderedItem> getOrdereditems() {
        return ordereditems;
    }

    public void setOrdereditems(List<OrderedItem> ordereditems) {
        this.ordereditems = ordereditems;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addOrderedItems(OrderedItem item){
        ordereditems.add(item);
        numberOfItems++;
    }
    
}
