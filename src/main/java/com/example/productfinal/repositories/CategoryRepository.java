package com.example.productfinal.repositories;

import com.example.productfinal.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Category save(Category category);
}
