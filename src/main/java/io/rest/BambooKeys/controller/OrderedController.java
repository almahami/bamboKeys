package io.rest.BambooKeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.Ordered;
import io.rest.BambooKeys.service.OrderedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class OrderedController {
    
    @Autowired
    private OrderedService orderedService;

    @GetMapping("/ordered/{userFK}")
    public List<Ordered> getOrderByUser(@PathVariable Long userFK) {
        return orderedService.getOrder(userFK);
        
    }
    
}
