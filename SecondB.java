import statemachine.State;

public class SecondB extends State {
    @Override
    public void doOnEnter(){
        System.out.println("Saw BB");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving BB state");
    };
}
