package com.danilo.springbootarchiteturehexagonal.application.usecase;

import com.danilo.springbootarchiteturehexagonal.domain.enumeration.Unit;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Log4j2
public class ValidateProductUseCase {

    public static void validateId(UUID id) {
        if (Objects.isNull(id)) {
            String msg = "Id cannot be null.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

    public static void validateName(String name) {
        if (Objects.isNull(name)) {
            String msg = "Name cannot be null.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        if (name.isBlank()) {
            String msg = "Name cannot be empty.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        if (name.length() > 100) {
            String msg = "NAME can only contain a maximum of 100 characters.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

    public static void validateUnit(Unit unit) {
        if (Objects.isNull(unit)) {
            String msg = "Unit cannot be null.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

    public static void validateUnitaryValue(BigDecimal unitaryValue) {
        if (Objects.isNull(unitaryValue)) {
            String msg = "Unitary value cannot be null.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        if (unitaryValue.doubleValue() <= 0.00) {
            String msg = "Unit value must be greater than 0.00";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

    public static void validateDueDate(LocalDate dueDate) {
        if (Objects.isNull(dueDate)) {
            String msg = "Due date cannot be null.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }

        if (dueDate.isBefore(LocalDate.now())) {
            String msg = "Due date must be greater than current date.";
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

}
