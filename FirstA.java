import statemachine.State;

public class FirstA extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("Saw A");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving A state");
    };
}

