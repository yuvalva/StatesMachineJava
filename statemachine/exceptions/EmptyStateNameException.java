package statemachine.exceptions;

public class EmptyStateNameException extends Exception {
    public EmptyStateNameException() {
        super("State name must be a non empty initialized string");
    }
}
