package statemachine.exceptions;

public class EmptyEventNameException extends IllegalArgumentException{
    public EmptyEventNameException() {
        super("Event name must be a non empty initialized string");
    }
}
