public class StateMachine {
    State currState;

    StateMachine(State initialState){
        currState = initialState;
    }

    public void handleEvent(MachineEvent evt)
    {
        State newState = currState.getNextState(evt);

        if(newState != currState)
        {
            currState.doBeforeLeave();
            newState.doOnEnter();
        }
        if (newState != null && currState != newState)
            currState = newState;
    }

}
