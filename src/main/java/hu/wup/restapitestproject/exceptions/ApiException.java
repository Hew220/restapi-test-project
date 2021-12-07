package hu.wup.restapitestproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiException {

    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timeStamp;

    public ApiException(String message, HttpStatus status, ZonedDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
