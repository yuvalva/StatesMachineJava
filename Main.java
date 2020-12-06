import statemachine.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        StateMachine threeConsecutiveEventsMachine = createThreeConsecutiveEventsMachine();

        handleEventsTest(threeConsecutiveEventsMachine);

        MachineEvent<Character> evtA = new MachineEvent<>('A');
        MachineEvent<Character> evtB = new MachineEvent<>('B');

        // Save machine state
        try {
            String filename = "machine.ser";
            threeConsecutiveEventsMachine.saveMachineStateToFile(filename);
            StateMachine newMachine = StateMachine.restoreMachine(filename);
            // handle some more events
            newMachine.handleEvent(evtA);
            newMachine.handleEvent(evtB);
        } catch (IOException ex) {
            System.out.println("IOException occurred" + System.lineSeparator() + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException occurred" + System.lineSeparator() + ex.getMessage());
        }
    }

    static StateMachine createThreeConsecutiveEventsMachine() {

        MachineEvent<Character> evtA = new MachineEvent<>('A');
        MachineEvent<Character> evtB = new MachineEvent<>('B');

        State initialState = new InitialState();
        State firstAState = new FirstA();
        State firstBState = new FirstB();
        State secondAState = new SecondA();
        State secondBState = new SecondB();
        State finalState = new ThirdConsecutiveEvent();

        finalState.setTransitions(evtA, finalState);
        finalState.setTransitions(evtB, finalState);

        secondAState.setTransitions(evtA, finalState);
        secondAState.setTransitions(evtB, firstBState);

        secondBState.setTransitions(evtA, firstAState);
        secondBState.setTransitions(evtB, finalState);

        firstAState.setTransitions(evtA, secondAState);
        firstAState.setTransitions(evtB, firstBState);

        firstBState.setTransitions(evtA, firstAState);
        firstBState.setTransitions(evtB, secondBState);

        initialState.setTransitions(evtA, firstAState);
        initialState.setTransitions(evtB, firstBState);

        StateMachine threeConsecutiveEventsMachine = new StateMachine(initialState);
        return threeConsecutiveEventsMachine;
    }

    static void handleEventsTest(StateMachine machine)
    {
        if(machine == null)
            return;

        MachineEvent<Character> evtA = new MachineEvent<>('A');
        MachineEvent<Character> evtB = new MachineEvent<>('B');

        try {
            machine.handleEvent(evtA);
            machine.handleEvent(evtA);
            machine.handleEvent(evtB);
            machine.handleEvent(evtA);
            machine.handleEvent(evtB);
            machine.handleEvent(evtB);
            machine.handleEvent(evtB);
            machine.handleEvent(evtA);
        } catch (StateNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
