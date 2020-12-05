import statemachine.*;

public class Main {
    public static void main(String[] args) {
        MachineEvent<Character> evtA = new MachineEvent<>('A') ;
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

        try {
            threeConsecutiveEventsMachine.handleEvent(evtA);
            threeConsecutiveEventsMachine.handleEvent(evtA);
            threeConsecutiveEventsMachine.handleEvent(evtB);
            threeConsecutiveEventsMachine.handleEvent(evtA);
            threeConsecutiveEventsMachine.handleEvent(evtB);
            threeConsecutiveEventsMachine.handleEvent(evtB);
            threeConsecutiveEventsMachine.handleEvent(evtB);
            threeConsecutiveEventsMachine.handleEvent(evtA);
        }
        catch (StateNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

        //String name = initState.getClass().getName();
    }
}
