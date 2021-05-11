package nl.teuno.simplecalculator.services.exceptions;

public class ShouldNotBePossibleException extends RuntimeException{
    public ShouldNotBePossibleException(String message) {
        super(message);
    }
}
