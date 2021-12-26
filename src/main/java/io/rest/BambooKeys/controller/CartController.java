package io.rest.BambooKeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.Cart;
import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.service.CartService;

@RestController
public class CartController {
    
    @Autowired 
    public CartService cartService;

    @GetMapping("/myCart/{userFK}")
    public List<Cart> getMyCart(@PathVariable Long userFK){
        return cartService.getMyCart(userFK);
    }

    @GetMapping("/listALLProductsMyCart/{userFK}")
    public List<Product> getAllProductsmyCart(@PathVariable Long userFK){
        return cartService.getProductmyCart(userFK);

    }


    @PostMapping("/addItemToCart/{userFK}/{productFK}/{quantity}")
    public Cart addItemToCart(@PathVariable Long userFK, @PathVariable Long productFK, @PathVariable int quantity){
        return cartService.addItemToCart(quantity, userFK, productFK);

    }

    @DeleteMapping("/deleteCart/{userFK}")
    public void deleteCart(@PathVariable Long userFK){
        cartService.deleteCart(userFK);
    }

    @DeleteMapping("/deleteProductFromCart/{userFK}/{productFK}")
    public void deleteProductFromCart(@PathVariable Long userFK, @PathVariable Long productFK){
        cartService.deleteProductFromCart(userFK, productFK);
    }
}
