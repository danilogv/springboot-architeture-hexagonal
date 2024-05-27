package com.danilo.springbootarchiteturehexagonal.application.dto;

import com.danilo.springbootarchiteturehexagonal.domain.enumeration.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductDTO {

    private UUID id;
    private String name;
    private Unit unit;
    private BigDecimal unitaryValue;
    private LocalDate dueDate;

}
