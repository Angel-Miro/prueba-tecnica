package com.pruebatecnica.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorCustomeResponse{
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;
}
