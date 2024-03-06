package com.example.be.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class BaseResponseDto<T> {

    @Builder.Default
    private int statusCode = HttpStatus.OK.value();

    @Builder.Default
    private String message = "Success";

    private T data;
}
