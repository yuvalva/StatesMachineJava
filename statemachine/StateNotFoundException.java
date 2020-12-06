package statemachine;

public class StateNotFoundException extends NullPointerException{
    StateNotFoundException(State stateFrom, MachineEvent evt) {
        super( "No transition found in the state " + stateFrom.getClass().getName() +
                " for the event represented by: " + evt.getData());
    }
}
