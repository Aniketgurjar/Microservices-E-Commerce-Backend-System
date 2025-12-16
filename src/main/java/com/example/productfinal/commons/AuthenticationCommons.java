package com.example.productfinal.commons;

import com.example.productfinal.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {
    RestTemplate restTemplate;
    AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    public UserDto validateToken(String token){
       ResponseEntity<UserDto>response= restTemplate.postForEntity("Http://localhost:8080/users/validate/"+token,null,UserDto.class);
if(response.getBody()==null){
    return null;
}
return response.getBody();
    }

}
