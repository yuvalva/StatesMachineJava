package statemachine;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class State implements Serializable {
    private Map<MachineEvent, State> statesTransitionsMap = new HashMap();

    // Optional logic the client can override when entering or leave a certain state
    public void doOnEnter(){};
    public void doBeforeLeave(){};

    // Api for the client to set a concrete state transitions
    public void setTransitions(MachineEvent evt, State newState)
    {
        statesTransitionsMap.put(evt, newState);
    }
    State getNextState(MachineEvent evt)
    {
        return statesTransitionsMap.get(evt);
    }

}
