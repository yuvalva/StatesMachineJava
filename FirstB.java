import statemachine.State;

public class FirstB extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("Saw B");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving B state");
    };
}

