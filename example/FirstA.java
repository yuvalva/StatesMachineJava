package example;

import statemachine.MachineEvent;
import statemachine.State;

public class FirstA extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("Saw A");
    };
    @Override
    public void doBeforeLeave(MachineEvent evt){
        System.out.println("Leaving A state");
    };
}

