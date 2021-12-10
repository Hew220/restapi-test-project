package hu.wup.restapitestproject.exceptions;

public class BookIsAlreadyExistException extends RuntimeException {

    public BookIsAlreadyExistException(String message) {
        super(message);
    }
}
