package com.example.productfinal.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Getter
@Setter
@Document(indexName = "products")
public class ProductSearch {

    @Id
    private Long id;

    private String title;

    private double price;

    private String description;

    private String image;

    private String category;

    private int quantity;

    private int quality;

    private Date createdAt;

    private Date updatedAt;
}