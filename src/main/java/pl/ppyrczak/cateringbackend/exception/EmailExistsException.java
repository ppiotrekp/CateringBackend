package pl.ppyrczak.cateringbackend.exception;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException() {
        super("Email exists");
    }
}
