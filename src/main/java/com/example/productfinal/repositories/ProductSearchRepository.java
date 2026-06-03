package com.example.productfinal.repositories;

import com.example.productfinal.models.ProductSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository
        extends ElasticsearchRepository<ProductSearch, Long> {
    List<ProductSearch> findByTitleContaining(String title);
}