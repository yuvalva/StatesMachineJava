package example;

import statemachine.MachineEvent;
import statemachine.State;

public class FirstB extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("Saw B");
    };
    @Override
    public void doBeforeLeave(MachineEvent evt){
        System.out.println("Leaving B state");
    };
}

