package com.example.productfinal.dtos;


import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String Email;
    private String name;


    private List<Role> roles;
    private boolean IsEmailVerified;


}