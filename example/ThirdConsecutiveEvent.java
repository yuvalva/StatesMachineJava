package example;

import statemachine.MachineEvent;
import statemachine.State;

public class ThirdConsecutiveEvent extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("The same event happened three consecutive times");
    };
}
