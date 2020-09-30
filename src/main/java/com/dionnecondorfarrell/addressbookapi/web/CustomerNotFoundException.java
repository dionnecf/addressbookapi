package com.dionnecondorfarrell.addressbookapi.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    String message;

    CustomerNotFoundException(){

    }

    CustomerNotFoundException(String message){
        this.message = message;
    }

}
