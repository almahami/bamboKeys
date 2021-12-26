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

    public CartService(Logger log) {
        this.log = log;
    }

    public List<Cart> getMyCart(Long userFK) {
        List<Cart> res = cartRepository.findCartByUserFK(userFK);
        if (!res.isEmpty()) {
            return cartRepository.findCartByUserFK(userFK);
        } else {
            throw new UserNotfoundException("user with id " + userFK + "Not found");
        }
    }

    // !! i don not have a login webepage, so i should define which user add item
    // !! to him / her Cart
    public Cart addItemToCart(int quantity, Long userFK, Long productFK) {
        Optional<User> userRes = userRepository.findById(userFK);
        Cart cart = new Cart();
        if (userRes.isPresent()) {
            Optional<Product> res = productRepository.findById(productFK);
            if (res.isPresent()) {
                if (quantity > 1) {

                    log.info("product with id " + productFK + " will be added to the cart");
                    log.info("added product " + res.get() + "to the cart");
                    int avalibaleAmount = res.get().getAmount();
                    if (avalibaleAmount > 0) {
                        if (quantity <= avalibaleAmount && avalibaleAmount > 0) {
                            int newQuantity = avalibaleAmount - quantity;
                            cart.setProductFK(res.get().getId());
                            cart.setUserFK(userRes.get().getId());
                            cart.setQuantity(quantity);
                            res.get().setAmount(newQuantity);
                            productRepository.save(res.get());
                        } else if (quantity > avalibaleAmount) {
                            throw new ProductException(
                                    "the quantity it is not avalibale, please choesse quantity smaller then or equals to "
                                            + res.get().getAmount());
                        }
                    } else {
                        throw new ProductException("product not avalibale anymore :)");
                    }
                    cartRepository.saveAndFlush(cart);
                    return cart;
                }else{
                    throw new ProductException("the quantity should be >=1");
                }
            } else {
                log.info("Product with id: " + productFK + " not Founded");
                throw new ProductException("Product with id: " + productFK + " not Founded");
            }
        } else {
            throw new UserNotfoundException("user with id: " + userFK + " Not Found");
        }
    }

}
