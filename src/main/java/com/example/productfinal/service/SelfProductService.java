package com.example.productfinal.service;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.models.Category;
import com.example.productfinal.models.Product;
import com.example.productfinal.repositories.CategoryRepository;
import com.example.productfinal.repositories.ProductRepository;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements  ProductService {
ProductRepository productRepository;
CategoryRepository categoryRepository;
SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
    this.productRepository=productRepository;
    this.categoryRepository=categoryRepository;
}


    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> optionalproduct= productRepository.findById(id);
        if(optionalproduct.isEmpty()){
            return null;
        }
        Product product=optionalproduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) throw new RuntimeException();

        if (product == null) throw new RuntimeException("Invalid Input exception to update Method");

        Product currentProduct = optionalProduct.get();

        if (product.getTitle() != null) {
            //If title isn't null that means we want to update the title.
            currentProduct.setTitle(product.getTitle());
        }

        if (product.getDescription() != null) {
            currentProduct.setDescription(product.getDescription());
        }

        return productRepository.save(currentProduct);
    }

    @Override
    public Product createProduct(Product product) {


        return productRepository.save(product);
    }

    @Override
    public void deleteProduct() {

    }
}
