package io.rest.BambooKeys.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Cart;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.CartRepository;

@Service
public class CartService {
    
    private Logger log;
    @Autowired
    private CartRepository cartRepository;

    public CartService(Logger log){
        this.log= log;
    }
 /*
    public Optional<Cart> getMyCart (Long userId){
       Optional<Cart> res= cartRepository.findCartById(userId);

       if(res.isEmpty()){
           log.info("result is empty");
           throw new UserNotfoundException("User does not found");
       }
       else{
           return cartRepository.findCartById(userId);
       }
    }

    public void addProductToCart(String username, String productName){
        
    }
*/
}
