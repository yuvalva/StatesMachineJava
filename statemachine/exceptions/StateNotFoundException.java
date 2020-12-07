package statemachine.exceptions;

public class StateNotFoundException extends NullPointerException{
    public StateNotFoundException(String stateFrom, String evtName) {
        super( "No transition found in the state " + stateFrom.getClass().getName() +
                " for the event represented by: " + evtName);
    }
}
