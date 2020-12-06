package example;

import statemachine.MachineEvent;
import statemachine.State;

public class SecondA extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("Saw AA");
    };
    @Override
    public void doBeforeLeave(MachineEvent evt){
        System.out.println("Leaving AA state");
    };
}
