package statemachine;
import java.io.*;

public class StateMachine implements Serializable {
    State currState;
    static final String MACHINE_SAVED = "Machine state was successfully saved to: ";

    public StateMachine(State initialState){
        currState = initialState;
    }

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
