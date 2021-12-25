 package io.rest.BambooKeys.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Cart;
import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.exception.ProductException;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.CartRepository;
import io.rest.BambooKeys.repository.ProductRepository;
import io.rest.BambooKeys.repository.UserRepository;

@Service
public class CartService {
    
    private Logger log;
    @Autowired
    private CartRepository cartRepository;
    @Autowired 
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public CartService(Logger log){
        this.log= log;
    }

    // !! i don not have a login webepage, so i should define whcih user add item
    // to him / her Cart
    public void addItemToCart(int quantity, Long userId, Long productId) {
        Optional<User> userRes = userRepository.findById(userId);
        if (userRes.isPresent()) {
            Optional<Product> res = productRepository.findById(productId);
            if (res.isPresent()) {
                log.info("product with id " + productId + " will be added to the cart");
                log.info("added product " + res.get() + "to the cart");
                
                Cart cart = new Cart();
                cart.setProductFK(res.get().getId());
                cart.setUserFK(userRes.get().getId());
                cart.setQuantity(quantity);
                
                cartRepository.saveAndFlush(cart);
            
            } else {
                log.info("Product with id: " + productId + " not Founded");
                throw new ProductException("Product with id: " + productId + " not Founded");
            }
        } else {
            throw new UserNotfoundException();
        }

    }

    public Cart getMyCart (Long userFK){
        Optional<Cart> res= cartRepository.findCartByUserFK(userFK);
        if(res.isPresent()){
            return cartRepository.findCartByUserFK(userFK).get();
        }
        else{
            throw new UserNotfoundException();

        }

    }
 /*
    public Cart getMyCart (Long userId){
       Optional<Cart> res= cartRepository.FIN(userId);

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
