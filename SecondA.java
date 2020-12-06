import statemachine.State;

public class SecondA extends State {
    @Override
    public void doOnEnter(){
        System.out.println("Saw AA");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving AA state");
    };
}
