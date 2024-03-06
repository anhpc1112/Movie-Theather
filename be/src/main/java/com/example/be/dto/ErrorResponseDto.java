package com.example.be.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto<T> {

    private int statusCode;

    private String message;

    private T data;
}
