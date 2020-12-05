import statemachine.State;

public class InitialState extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("In initial state");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("not anymore in initial state");
    };
}
