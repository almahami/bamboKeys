package io.rest.BambooKeys.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.OrderedItem;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.OrderdItemRepository;
import io.rest.BambooKeys.repository.UserRepository;

@Service
public class OrderedItemService {
    
    private Logger log;
    @Autowired 
    private OrderdItemRepository orderdItemRepository;
    @Autowired
    private UserRepository userRepository;
    public OrderedItemService(Logger log ){
        this.log=log;
    }


    public void saveOrderedItem(Long userFK, OrderedItem orderedItem){
        Optional<User> res = userRepository.findById(userFK);
        if(res.isPresent()){
            log.info("save ordered Item" + orderedItem.toString());
            orderdItemRepository.save(orderedItem);
        }
        else{
            throw new UserNotfoundException("could not found user with id " + userFK );
        }
    }
    
}
