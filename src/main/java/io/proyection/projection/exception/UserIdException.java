package io.proyection.projection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdException extends RuntimeException {

    public UserIdException(String message) {
        super(message);
    }
}