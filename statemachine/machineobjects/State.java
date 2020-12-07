package statemachine.machineobjects;

import statemachine.exceptions.EmptyStateNameException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class State implements Serializable {
    private String name;
    // Map event to new state by their string id
    private Map<String, String> statesTransitionsMap = new HashMap();

    // Optional logic the client can override when entering or leaving a certain state
    public void doOnEnter(MachineEvent evt){};
    public void doBeforeLeave(MachineEvent evt){};

    // Api for the client to set a concrete state transitions
    public void setTransitions(MachineEvent evt, State newState)
    {
        statesTransitionsMap.put(evt.getName(), newState.getName());
    }

    String getNextStateName(MachineEvent evt)
    {
        return statesTransitionsMap.get(evt.getName());
    }

    public void setName(String stateName) {
        if(stateName.isEmpty() || stateName == null)
            throw new EmptyStateNameException();

        name = stateName;
    }
    public String getName(){
        return name;
    }
}
