package com.example.productfinal.controller;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.commons.AuthenticationCommons;
import com.example.productfinal.dtos.UserDto;
import com.example.productfinal.models.Product;
import com.example.productfinal.models.ProductSearch;
import com.example.productfinal.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final AuthenticationCommons authenticationCommons;

    public ProductController(ProductService productService,
                             AuthenticationCommons authenticationCommons) {

        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
            throws InvalidProductIdException {

        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/all/{token}")
    public ResponseEntity<List<Product>> getAllProducts(
            @PathVariable String token) {

        UserDto userDto = authenticationCommons.validateToken(token);

        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Product> listOfProducts = productService.getAllProducts();

        return new ResponseEntity<>(listOfProducts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody Product product) {

        Product createdProduct = productService.createProduct(product);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(id, product);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductSearch>> searchProducts(
            @RequestParam String query) {

        List<ProductSearch> products =
                productService.searchProducts(query);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}