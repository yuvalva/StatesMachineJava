import statemachine.State;

public class ThirdConsecuiveEvent extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("The same event happened three consecutive times");
    };
}
