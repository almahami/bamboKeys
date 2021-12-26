package io.rest.BambooKeys.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Ordered;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.OrderedRepository;
import io.rest.BambooKeys.repository.UserRepository;



@Service
public class OrderedService {
    
    private Logger log;
    @Autowired
    private OrderedRepository orderedRepository;
    @Autowired 
    private UserRepository userRepository;
    public OrderedService (Logger log){
        this.log=log; 
    }

    public List<Ordered> getOrder(Long  userFK){
        List<User> userRes = userRepository.findAllById(userFK);
        if(userRes.isEmpty()){
            log.error("user with id: "+ userFK+ " have no Order");
            throw new UserNotfoundException("user have no Order");
        }
        else{
            log.info("user have Following order: " +orderedRepository.findAllOrderWithUserFK(userFK) );
           return orderedRepository.findAllOrderWithUserFK(userFK);
        }
    }
}
