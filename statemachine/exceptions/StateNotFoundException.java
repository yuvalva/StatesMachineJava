package statemachine.exceptions;

public class StateNotFoundException extends Exception{
    public StateNotFoundException(String stateFromName, String evtName) {
        super( "No transition found in the state " + stateFromName + " for the event: " + evtName);
    }
}
