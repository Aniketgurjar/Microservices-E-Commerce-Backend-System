package com.example.productfinal.controller;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.commons.AuthenticationCommons;
import com.example.productfinal.dtos.UserDto;
import com.example.productfinal.models.Product;
import com.example.productfinal.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/products")

public class ProductController {
    ProductService productService;
    AuthenticationCommons authenticationCommons;
    ProductController(ProductService productService,AuthenticationCommons authenticationCommons){
        this.productService=productService;
        this.authenticationCommons=authenticationCommons;
    }

    @GetMapping("/{id}")

    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id ) throws InvalidProductIdException {
Product p=null;

try{
  p=productService.getProductById(id)  ;
}catch (RuntimeException e){
    return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
}

        return  new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("all/{token}")
    public ResponseEntity<List<Product>>getAllProducts(@PathVariable String token){

        UserDto userDto=authenticationCommons.validateToken(token);
        if(userDto==null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        //validate the token
         List<Product>listofproducts=productService.getAllProducts();
        return new ResponseEntity<>(listofproducts,HttpStatus.OK);
    }
    @PostMapping("/{id}")

    public Product CreateProduct(@RequestBody Product product){
       productService.createProduct(product);
       return product;
    }
    @PatchMapping ("/{id}")
    public Product UpdateProduct(@PathVariable("id") Long id ,@RequestBody Product product){
    productService.updateProduct(id,product);
    return product;

    }
    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Long id){

    }
}
