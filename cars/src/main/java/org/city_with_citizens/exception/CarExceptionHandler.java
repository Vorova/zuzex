package org.city_with_citizens.exception;

import org.city_with_citizens.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class CarExceptionHandler {

    @ExceptionHandler(CarException.class)
    public ResponseEntity<ExceptionDto> carException(CarException exception) {
        return new ResponseEntity<>(
                ExceptionDto.builder()
                        .title(exception.getClass().getName())
                        .message(exception.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException exception) {
        return new ResponseEntity<>(
                ExceptionDto.builder()
                        .title(exception.getClass().getName())
                        .message(exception.getMessage())
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

}
