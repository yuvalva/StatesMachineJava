import statemachine.State;

public class ThirdConsecutiveEvent extends State {
    @Override
    public void doOnEnter(){
        System.out.println("The same event happened three consecutive times");
    };
}
