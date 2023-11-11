package ru.alemakave.coursework_2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OutOfBoundsException extends HttpStatusCodeException {
    public OutOfBoundsException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public OutOfBoundsException(String statusText) {
        super(HttpStatus.BAD_REQUEST, statusText);
    }
}
