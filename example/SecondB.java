package example;

import statemachine.MachineEvent;
import statemachine.State;

public class SecondB extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("Saw BB");
    };
    @Override
    public void doBeforeLeave(MachineEvent evt){
        System.out.println("Leaving BB state");
    };
}
