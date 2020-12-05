package statemachine;

public class StateMachine {
    State currState;

    public StateMachine(State initialState){
        currState = initialState;
    }

    // handle events sent by the client
    public synchronized void handleEvent(MachineEvent evt) throws StateNotFoundException
    {
        State newState = currState.getNextState(evt);
        if(newState == null)
            throw new StateNotFoundException(currState, evt);

        if(newState != currState)
        {
            currState.doBeforeLeave();
            newState.doOnEnter();
            currState = newState;
        }
    }

}
