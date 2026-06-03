package com.example.productfinal.service;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.models.Product;
import com.example.productfinal.models.ProductSearch;
import com.example.productfinal.repositories.CategoryRepository;
import com.example.productfinal.repositories.ProductRepository;
import com.example.productfinal.repositories.ProductSearchRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductSearchRepository productSearchRepository;

    SelfProductService(ProductRepository productRepository,
                       CategoryRepository categoryRepository,
                       ProductSearchRepository productSearchRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productSearchRepository = productSearchRepository;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            return null;
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty())
            throw new RuntimeException();

        Product currentProduct = optionalProduct.get();

        if (product.getTitle() != null) {
            currentProduct.setTitle(product.getTitle());
        }

        if (product.getDescription() != null) {
            currentProduct.setDescription(product.getDescription());
        }

        Product updated = productRepository.save(currentProduct);

        ProductSearch searchDoc = new ProductSearch();
        searchDoc.setId(updated.getId());
        searchDoc.setTitle(updated.getTitle());
        searchDoc.setDescription(updated.getDescription());
        searchDoc.setPrice(updated.getPrice());

        productSearchRepository.save(searchDoc);

        return updated;
    }

    public Product createProduct(Product product) {

        Product savedProduct = productRepository.save(product);

        ProductSearch searchDoc = new ProductSearch();

        searchDoc.setId(savedProduct.getId());
        searchDoc.setTitle(savedProduct.getTitle());
        searchDoc.setDescription(savedProduct.getDescription());
        searchDoc.setPrice(savedProduct.getPrice());
        searchDoc.setImage(savedProduct.getImage());

        searchDoc.setCreatedAt(savedProduct.getCreatedAt());
        searchDoc.setUpdatedAt(savedProduct.getUpdatedAt());

        if (savedProduct.getCategory() != null) {
            searchDoc.setCategory(savedProduct.getCategory().getTitle());
        }

        productSearchRepository.save(searchDoc);

        return savedProduct;
    }

    @Override
    public void deleteProduct() {
    }
    @Override
    public List<ProductSearch> searchProducts(String query) {
        return productSearchRepository.findByTitleContaining(query);
    }
}