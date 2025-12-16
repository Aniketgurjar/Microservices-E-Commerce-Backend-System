package com.example.productfinal.advices;

import com.example.productfinal.Exceptions.ExceptionDto;
import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.dtos.ArithmeticExceptionDto;
import com.example.productfinal.dtos.ArrayIndexOutOfBoundsExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException() {
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("Something went wrong");
      return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayIndexOutOfBoundsExceptionDto> handleIOBException() {
        return null;
    }
    @ExceptionHandler(InvalidProductIdException.class)
public ResponseEntity<ExceptionDto>handleInvalidProductIdException(){
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setMessage("exception caught");
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);


}



}