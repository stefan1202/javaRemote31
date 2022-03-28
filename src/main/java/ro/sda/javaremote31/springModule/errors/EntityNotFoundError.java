package ro.sda.javaremote31.springModule.errors;

public class EntityNotFoundError extends RuntimeException{
    public EntityNotFoundError(String message) {
        super(message);
    }
}
