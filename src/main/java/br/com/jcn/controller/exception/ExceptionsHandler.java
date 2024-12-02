package br.com.jcn.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e, WebRequest request) {

        ExceptionDTO exceptionDTO = ExceptionDTO.builder().code(HttpStatus.NOT_FOUND.value())
                .description(e.getMessage())
                .build();

        return handleExceptionInternal(e, exceptionDTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }
}