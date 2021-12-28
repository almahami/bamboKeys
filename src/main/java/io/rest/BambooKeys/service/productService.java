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
public class ProductService {
    
    private Logger log;

    @Autowired
    private ProductRepository productRepository;

    public ProductService(Logger log){
        this.log=log;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    } 

    public List<Product> findProductWithName(String productName){
        List<Product> res = productRepository.findByProductName(productName);

        if(res.isEmpty()){
            log.error("Product: " + productName +" not Found");
            throw new ProductException("Can not found any Product with name: " + productName);
        }
        else{
            return productRepository.findByProductName(productName);
        }
    }

    public Optional<Product> findProductWithNameAndMarke(String productName, String productMarke){
        Optional<Product> res = productRepository.findByproductNameAndMarke(productName, productMarke);

        if(res.isEmpty()){
            log.error("Product: " + productName + "Marke: " + productMarke +" not Found");
            throw new ProductException("Can not found any Product with name:  " + productName + ", Marke:"  + productMarke);
        }
        else{
            return productRepository.findByproductNameAndMarke(productName, productMarke);
        }
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
        Product newProduct =  productRepository.saveAndFlush(product);
        log.info("Saved user with id" + newProduct.getId());
        log.info("user saved" + newProduct.toString());
        productRepository.saveAndFlush(newProduct);
        return newProduct;
    }

    public Product replaceProduct(Product newProduct, Long id){
        return productRepository.findById(id)
        .map(product -> {
            log.info("old product: " + productRepository.findById(id).get());
            product.setName(newProduct.getName());
            product.setAmount(newProduct.getAmount());
            product.setDescrpetion(newProduct.getDescrpetion());
            product.setPrice(newProduct.getPrice());
            product.setMarke(newProduct.getMarke());
           
            log.info("replace was successful: " + product.toString());
            return productRepository.save(product);
        })
        .orElseThrow( () -> new ProductException("Can not Found Product with " + id));
    
    }

    public void deleteProduct(Long id){

        Optional<Product> result= productRepository.findById(id);
        if(result.isEmpty()){
            log.error(("can not Found Product with " + id));
            throw new ProductException("can not Found Product with id: " + id);
        }
        else{
            log.warn("delete product with id: " + id);
            productRepository.deleteById(id);
        }
    }

    public void deleteALLProduct(){
        List<Product> result = productRepository.findAll();

        if (result.isEmpty()) throw new ProductException("does not  Found any Product");
        log.warn("Delete ALL Product!!! ");
        productRepository.deleteAll();
    }

    public boolean exsistingProduct(Long productFK ){
        Optional<Product> productRes = productRepository.findById(productFK);
        if(productRes.isPresent()){
            log.info("Product exisit in DB");
            return true;
        }else{
            log.error("product not Found");
            throw new ProductException(productFK);
            
        }
    }
}
