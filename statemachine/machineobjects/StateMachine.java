package statemachine.machineobjects;
import statemachine.exceptions.EmptyStateNameException;
import statemachine.exceptions.StateNotFoundException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StateMachine implements Serializable {
    private State currState;
    private Map<String, State> stateNameToStateMap = new HashMap();
    static private final String MACHINE_SAVED = "Machine state was successfully saved to: ";

    public StateMachine(State initialState){

        currState = initialState;
    }

    public synchronized void handleEvent(MachineEvent evt) throws StateNotFoundException, EmptyStateNameException
    {
        if(evt.getName() == null || evt.getName().isEmpty())
            throw new EmptyStateNameException();

        String newStateName = currState.getNextStateName(evt);
        State newState = stateNameToStateMap.get(newStateName);

        if(newState == null)
            throw new StateNotFoundException(currState.getName(), evt.getName());

        if(newState != currState)
        {
            currState.doBeforeLeave(evt);
            newState.doOnEnter(evt);
            currState = newState;
        }
    }

    // mapping each stata name to the state to recognize a state by its name
    // prevents saving many states references in the state class Map
    public State addState(State state)
    {

        if(state == null || state.getName() == null || state.getName().isEmpty())
            return null;

        stateNameToStateMap.put(state.getName(), state);
        return state;
    }

    public void saveMachineStateToFile(String filePath) throws IOException
    {
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
        out.close();
        file.close();
        System.out.println(MACHINE_SAVED + filePath);
    }

    public static StateMachine restoreMachine(String filePath) throws IOException, ClassNotFoundException
    {
        StateMachine restoredMachine;
        FileInputStream fileStream = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fileStream);

        restoredMachine = (StateMachine)inputStream.readObject();

        inputStream.close();
        fileStream.close();
        return restoredMachine;
    }
}
