public class StateMachine {
    State currState;

    StateMachine(State initialState){
        currState = initialState;
    }

    void handleEvent(MachineEvent evt)
    {
        State newState = currState.getNextState(evt);

        if (currState != null && currState != newState)
            currState =  newState;
    }
}
