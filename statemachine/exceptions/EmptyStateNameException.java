package statemachine.exceptions;

public class EmptyStateNameException extends IllegalArgumentException {
    public EmptyStateNameException() {
        super("State name must be a non empty initialized string");
    }
}
