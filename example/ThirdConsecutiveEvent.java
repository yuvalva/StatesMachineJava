package example;
import statemachine.machineobjects.MachineEvent;
import statemachine.machineobjects.State;

public class ThirdConsecutiveEvent extends State {
    @Override
    public void doOnEnter(MachineEvent evt){
        System.out.println("The event '" + evt.getName() + "' happened three consecutive times");
    };
}
