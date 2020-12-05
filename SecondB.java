public class SecondB extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("Saw BB");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving BB state");
    };
}
