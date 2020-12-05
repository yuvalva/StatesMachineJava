import statemachine.State;

public class ThirdConsecutiveEvent extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("The same event happened three consecutive times");
    };
}
