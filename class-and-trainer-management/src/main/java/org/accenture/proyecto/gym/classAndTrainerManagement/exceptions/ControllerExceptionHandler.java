package org.accenture.proyecto.gym.classAndTrainerManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage apiExceptionHandler(ErrorMessage ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return message;
    }

    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ErrorMessage noContentExceptionHandler(ErrorMessage ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NO_CONTENT.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return message;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundExceptionHandler(ErrorMessage ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return message;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage illegalArgumentExceptionHandler(ErrorMessage ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return message;
    }

}
