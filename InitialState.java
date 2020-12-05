public class InitialState implements State<Character> {

    public State getNextState(MachineEvent evt)
    {
        if(evt.data.equals('A'))
        {
            return new FirstA();
        }
        else if(evt.data.equals('B'))
        {
            return  new FirstB();
        }
        else
        {
            return null;
        }
    }
    public void doLogic(){}
}
