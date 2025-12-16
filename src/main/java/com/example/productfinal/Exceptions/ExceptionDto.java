package com.example.productfinal.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    String Message;

}
