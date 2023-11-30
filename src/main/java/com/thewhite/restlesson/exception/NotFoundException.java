package com.thewhite.restlesson.exception;

/**
 * Исключение - запись не найдена
 *
 * @author Sergei Vorona
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
