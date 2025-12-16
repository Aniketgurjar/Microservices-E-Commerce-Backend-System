package com.example.productfinal.repositories;

import com.example.productfinal.models.Category;
import com.example.productfinal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   Optional<Product> findById(Long id);
   Optional<Product>findByTitleAndDescription(String title,String description);
   Optional<Product>findByTitleContaining(String word);
    List<Product> findTop3ByTitleContaining(String word);

   Optional<Product>findByCategory(Category category);
   void deleteById(Long id);
Product save(Product product);
}
