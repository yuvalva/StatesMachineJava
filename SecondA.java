public class SecondA extends State<Character> {
    @Override
    public void doOnEnter(){
        System.out.println("Saw AA");
    };
    @Override
    public void doBeforeLeave(){
        System.out.println("Leaving AA state");
    };
}
