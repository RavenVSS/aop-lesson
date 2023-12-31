package com.thewhite.aoplesson.api;

import com.thewhite.aoplesson.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Sergei Vorona
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * При появлении исключения {@link NotFoundException} возвращает статус 404 и сообщение об ошибке.
     */
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto processNotFoundException(NotFoundException exception) {
        return ErrorDto.of(exception.getMessage());
    }
}
