package com.example.be.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BadRequestException extends RuntimeException {

    private String errorCode;
    private String message;

}
