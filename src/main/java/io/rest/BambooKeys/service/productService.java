package io.rest.BambooKeys.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.Product;
import io.rest.BambooKeys.exception.ProductException;
import io.rest.BambooKeys.repository.ProductRepository;

@Service
public class productService {
    
    private Logger log;

    @Autowired
    private ProductRepository productRepository;

    public productService(Logger log){
        this.log=log;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    } 

    public Product getProduct(Long id){
        Optional<Product> result= productRepository.findById(id);
        
        if(result.isEmpty()){
            log.info("product Not Found");
            throw new ProductException("Product with " + id + "not Fonud");  
        } 
        else{
            log.info("product at " + id +"is" + result.get());
            return result.get();
        }
    }

    public Product addProduct(Product product){
        Product newProduct = productRepository.save(product);
        log.info("Save new Product" + newProduct.toString() + "with id " + newProduct.getId());
        return newProduct;
    }

    public Product replaceProduct(Product newProduct, Long id){
        return productRepository.findById(id)
        .map(product -> {
            log.info("old product" + productRepository.findById(id).get());
            product.setName(newProduct.getName());
            product.setAmount(newProduct.getAmount());
            product.setDescrpetion(newProduct.getDescrpetion());
            product.setPrice(newProduct.getPrice());
            product.setMarke(newProduct.getMarke());
           
            log.info("replace was successful" + product.toString());
            return productRepository.save(product);
        })
        .orElseThrow( () -> new ProductException("Can not Found Product with " + id));
    
    }

    public void deleteProduct(Long id){

        Optional<Product> result= productRepository.findById(id);
        if(result.isEmpty()){
            log.warn(("can not Found Product with " + id));
            throw new ProductException("can not Found Product with" + id);
        }
        else{
            log.warn("delete product with" + id);
            productRepository.deleteById(id);
        }
    }

    public void deleteALLProduct(){
        List<Product> result = productRepository.findAll();

        if (result.isEmpty()) throw new ProductException("does not  Found any Product");
        log.warn("Delte ALL Product ");
        productRepository.deleteAll();
    }
}
