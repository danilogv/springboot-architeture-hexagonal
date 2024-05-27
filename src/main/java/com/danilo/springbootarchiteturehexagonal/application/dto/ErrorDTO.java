package com.danilo.springbootarchiteturehexagonal.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ErrorDTO {

    private Integer status;
    private String message;
    private LocalDateTime timestamp;

}
