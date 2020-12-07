package statemachine.exceptions;

public class EmptyEventNameException extends Exception{
    public EmptyEventNameException() {
        super("Event name must be a non empty initialized string");
    }
}
