package statemachine;

public class StateMachine {
    State currState;

    public StateMachine(State initialState){
        currState = initialState;
    }

    public void handleEvent(MachineEvent evt) throws StateNotFoundException
    {
        State newState = currState.getNextState(evt);
        if(newState == null)
            throw new StateNotFoundException(currState, evt);

        if(newState != currState)
        {
            currState.doBeforeLeave();
            newState.doOnEnter();
        }
        if (newState != null && currState != newState)
            currState = newState;
    }

}
