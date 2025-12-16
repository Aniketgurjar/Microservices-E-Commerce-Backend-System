package com.example.productfinal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  //  private long id;
    private String title;
}