package example;

import statemachine.exceptions.StateNotFoundException;
import statemachine.machineobjects.MachineEvent;
import statemachine.machineobjects.State;
import statemachine.machineobjects.StateMachine;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        StateMachine threeConsecutiveEventsMachine = createThreeConsecutiveEventsMachine();

        handleEventsTest(threeConsecutiveEventsMachine);

        MachineEvent evtA = new MachineEvent("A", 'A');
        MachineEvent evtB = new MachineEvent("B", 'B');

        // Save machine state
        try {
            String filename = "machine.ser";
            threeConsecutiveEventsMachine.saveMachineStateToFile(filename);
            StateMachine newMachine = StateMachine.restoreMachine(filename);
            // handle some more events
            newMachine.handleEvent(evtA);
            newMachine.handleEvent(evtA);
        } catch (IOException ex) {
            System.out.println("IOException occurred" + System.lineSeparator() + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException occurred" + System.lineSeparator() + ex.getMessage());
        }
    }

    static StateMachine createThreeConsecutiveEventsMachine() {

        MachineEvent evtA = new MachineEvent("A",'A');
        MachineEvent evtB = new MachineEvent("B",'B');

        // create the states
        State initialState = new InitialState();
        initialState.setName("no input");

        State firstAState = new FirstA();
        firstAState.setName("A");

        State firstBState = new FirstB();
        firstBState.setName(("B"));

        State secondAState = new SecondA();
        secondAState.setName("AA");

        State secondBState = new SecondB();
        secondBState.setName("BB");

        State finalState = new ThirdConsecutiveEvent();
        finalState.setName("end state");

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

        // create state and add all of its states
        StateMachine threeConsecutiveEventsMachine = new StateMachine(initialState);
        threeConsecutiveEventsMachine.addState(initialState);
        threeConsecutiveEventsMachine.addState(firstAState);
        threeConsecutiveEventsMachine.addState(firstBState);
        threeConsecutiveEventsMachine.addState(secondAState);
        threeConsecutiveEventsMachine.addState(secondBState);
        threeConsecutiveEventsMachine.addState(finalState);

        return threeConsecutiveEventsMachine;
    }

    static void handleEventsTest(StateMachine machine)
    {
        if(machine == null)
            return;

        MachineEvent evtA = new MachineEvent("A",'A');
        MachineEvent evtB = new MachineEvent("B",'B');

        try {
            machine.handleEvent(evtA);
            machine.handleEvent(evtB);
            machine.handleEvent(evtA);
            machine.handleEvent(evtB);
            machine.handleEvent(evtB);
            machine.handleEvent(evtA);
            machine.handleEvent(evtB);
            machine.handleEvent(evtA);
        } catch (StateNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
