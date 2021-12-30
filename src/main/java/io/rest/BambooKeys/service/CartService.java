package io.rest.BambooKeys.service;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Cart;
import io.rest.BambooKeys.entity.Ordered;
import io.rest.BambooKeys.entity.OrderedItem;
import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.exception.CartExcpetion;
import io.rest.BambooKeys.exception.ProductException;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.CartRepository;
import io.rest.BambooKeys.repository.OrderedRepository;
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
    @Autowired
    private OrderedRepository orderedRepository;
    @Autowired
    OrderedItemService orderedItemService;
    
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

    public List<Product> getProductmyCart(Long userFK) {
        List<Long> res = cartRepository.getProductsByUserFK(userFK);
        if (!res.isEmpty()) {
            List<Product> productsList = productRepository.findAllById(res);
            return productsList;
        } else {
            throw new UserNotfoundException("user with id " + userFK + "Not found");

        }
    }

    public boolean haveUserWithIdACart( Long userFK){
        List<Cart> res = cartRepository.findCartByUserFK(userFK);
        if (!res.isEmpty()) {
            return true;
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
                    if (cartRepository.getProductsByUserFK(userFK).contains(productFK)) {
                        throw new CartExcpetion("The product is already added to the Cart");
                    } else {

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
                    }
                } else {
                    throw new ProductException("the quantity should be >=1");
                }
            } else {
                log.error("Product with id: " + productFK + " not Founded");
                throw new ProductException("Product with id: " + productFK + " not Founded");
            }
        } else {
            throw new UserNotfoundException("user with id: " + userFK + " Not Found");
        }
    }

    public void deleteCart(Long userFK) {
        List<Cart> cart = getMyCart(userFK);
        if (!cart.isEmpty()) {
            cartRepository.deleteCartByUserFK(userFK);
            log.warn("remove Cart for user with id " + userFK);
        } else {
            log.error("Cart is already empty " + userFK);
            throw new CartExcpetion("Cart is already empty");
        }
    }

    public void deleteProductFromCart(Long userFK, Long productFK){
        Optional<User> userRes = userRepository.findById(userFK);
        if(userRes.isPresent()){
            if(cartRepository.getProductsByUserFK(userRes.get().getId()).contains(productFK)){
                log.warn("product with id" + productFK + " will be removed from the Cart ");
                cartRepository.deleteProductFromCart(productFK,userFK);

            }else{
                throw new CartExcpetion("Product is not added to the Cart yet!");
            }
        } else {
            throw new UserNotfoundException("user with id: " + userFK + " Not Found");
        }
    }

    
    public Ordered checkout(Long userFK){
        if(haveUserWithIdACart(userFK)){
        List<Long> itemsId = cartRepository.getProductsByUserFK(userFK);
        Ordered ordered = new Ordered();
        ordered.setUserFK(cartRepository.searchCartWithUserFK(userFK).get());
        
        
        List<Product> itemList = productRepository.findAllById(itemsId);
        List<OrderedItem> orderedItems = new LinkedList<>();

        for(Product p : itemList){
            OrderedItem oi= new OrderedItem();
            oi.setDate(new Date());
            oi.setQuantity(cartRepository.getQuantityForProduct(p.getId(),userFK));
            oi.setProducts(itemList);
            oi.setUserFK(cartRepository.searchCartWithUserFK(userFK).get());
            orderedItems.add(oi);
            log.info("add items to OrderedItems " + oi.getId());
            orderedItemService.saveOrderedItem(userFK, oi);
            
        }
        ordered.setOrdereditems(orderedItems);
        ordered.setNumberOfItems(orderedItems.size());
        ordered.setDate(new Date());
        log.info("Saved Order for user" + userFK + "at Time " + new Date());
        orderedRepository.save(ordered);
        log.warn("Delete the Shop Cart for user with id " + userFK);
        deleteCart(userFK);
        log.info("returend Orderd" + ordered.toString());
        return ordered;
        }else{
            throw new UserNotfoundException("user with id: " + userFK + " Not Found");
        }
    }

        // u
    /*
        public Ordered checkout(Cart cart, Long userFK){
                
            Ordered ordered = new Ordered();
            ordered.setUserFK(cart.getUserFK());
            List<Long> itemsId = cartRepository.getProductsByUserFK(userFK);
            List<Product> itemList = productRepository.findAllById(itemsId);
            List<OrderedItem> orderedItems = new LinkedList<>();
    
            for(Product p : itemList){
                OrderedItem oi= new OrderedItem();
                oi.setDate(new Date());
                oi.setQuantity(p.getAmount());
                oi.setProducts(itemList);
                oi.setUserFK(cartRepository.searchCartWithUserFK(userFK).get());
                orderedItems.add(oi);
                log.info("add items to OrderedItems " + oi.getId());
                orderedItemService.saveOrderedItem(userFK, oi);
                            
            }
            ordered.setOrdereditems(orderedItems);
            ordered.setNumberOfItems(orderedItems.size());
            ordered.setDate(new Date());
            log.info("Saved Order for user" + userFK + "at Time " + new Date());
            orderedRepository.save(ordered);
            log.warn("Delete the Shop Cart for user with id " + userFK);
            deleteCart(userFK);
            log.info("returend Orderd" + ordered.toString());
            return ordered;
        }
        */
}
