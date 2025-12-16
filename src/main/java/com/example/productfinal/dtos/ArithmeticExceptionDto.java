package com.example.productfinal.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ArithmeticExceptionDto {
    String Message;
 String Detail;

    public String getMessage() {
        return Message;
    }

    public void setMessege(String message) {
        Message = message;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail=Detail;
    }
}
