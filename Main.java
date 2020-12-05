public class Main {
    public static void main(String[] args) {
        MachineEvent<Character> evtA = new MachineEvent<>('A') ;
        MachineEvent<Character> evtB = new MachineEvent<>('B');

        State initState = new InitialState();
        StateMachine threeConsecutiveEvents = new StateMachine(initState);
        threeConsecutiveEvents.handleEvent(evtA);
        threeConsecutiveEvents.handleEvent(evtA);
        threeConsecutiveEvents.handleEvent(evtB);
        threeConsecutiveEvents.handleEvent(evtA);
        threeConsecutiveEvents.handleEvent(evtB);
        threeConsecutiveEvents.handleEvent(evtB);
        threeConsecutiveEvents.handleEvent(evtB);
        threeConsecutiveEvents.handleEvent(evtA);
    }
}
