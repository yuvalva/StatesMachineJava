package example;

import statemachine.MachineEvent;
import statemachine.State;

public class InitialState extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("In initial state");
    };
    @Override
    public void doBeforeLeave(MachineEvent evt){
        System.out.println("not anymore in initial state");
    };
}
