package io.hexlet.xo.model.exceptions;

public class InvalidPointException extends AbstractXOException{

    public InvalidPointException() {
        super();
    }

    public InvalidPointException(String message) {
        super(message);
    }
}
