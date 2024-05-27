package com.danilo.springbootarchiteturehexagonal.domain.utility;

import com.danilo.springbootarchiteturehexagonal.application.design_patterns.singleton.Singleton;
import com.danilo.springbootarchiteturehexagonal.application.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> errorBusinessRule(ResponseStatusException ex) {
        HttpStatusCode status = ex.getStatusCode();
        String msg = ex.getReason();
        ErrorDTO error = this.getError(status.value(),msg);
        return new ResponseEntity<>(error,status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> errorArgumentInvalid(MethodArgumentNotValidException ex) {
        if (Objects.nonNull(ex.getFieldError())) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            String msg = ex.getFieldError().getDefaultMessage();
            ErrorDTO error = this.getError(status.value(),msg);
            return new ResponseEntity<>(error,status);
        }
        else {
            ErrorDTO error = this.genericError();
            return new ResponseEntity<>(error,HttpStatusCode.valueOf(error.getStatus()));
        }
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> errorArgumentTypeInvalid(MethodArgumentTypeMismatchException ex) {
        if (Objects.nonNull(ex.getRequiredType()) && ex.getRequiredType().getName().equals("java.util.UUID")) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            String msg = "Invalid format UUID.";
            ErrorDTO error = this.getError(status.value(),msg);
            return new ResponseEntity<>(error,status);
        }
        else {
            ErrorDTO error = this.genericError();
            return new ResponseEntity<>(error,HttpStatusCode.valueOf(error.getStatus()));
        }
    }

    private ErrorDTO getError(int status,String msg) {
        ErrorDTO error = Singleton.getError();
        error.setStatus(status);
        error.setMessage(msg);
        error.setTimestamp(LocalDateTime.now());
        return error;
    }

    private ErrorDTO genericError() {
        Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String msg = "Internal server error.";
        ErrorDTO error = Singleton.getError();
        error.setStatus(status);
        error.setMessage(msg);
        error.setTimestamp(LocalDateTime.now());
        return error;
    }

}
