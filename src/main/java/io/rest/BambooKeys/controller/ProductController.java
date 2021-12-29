package io.rest.BambooKeys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/productWithName/{productName}")
    public List<Product> getproductWithName(@PathVariable String productName){
        return productService.findProductWithName(productName);
    }

    @GetMapping("/productWithNameAndMarke/{productName}/{productMarke}")
    public Optional<Product> getproductWithNameAndMarke(@PathVariable String productName, @PathVariable String productMarke){
        return productService.findProductWithNameAndMarke(productName, productMarke);
    }

    //!!: JSON parse error: null; nested exception is com.fasterxml.jackson.databind.
    //!!JsonMappingException: N/A
    //!!!at [Source: (PushbackInputStream); 
    //!!reference chain: io.rest.BambooKeys.entity.Product["productReview"])]
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product ){
        return productService.replaceProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public void  deleteProduct(@PathVariable Long id ){
        productService.deleteProduct(id);
    }

    @DeleteMapping("/products")
    public void deleteAllProduct(){
        productService.deleteALLProduct();
    }
}
