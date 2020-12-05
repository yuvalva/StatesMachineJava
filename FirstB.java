public class FirstB implements State<Character> {
    public State getNextState(MachineEvent evt)
    {
        if(evt.data.equals('A'))
        {
            return new FirstA();
        }
        else if(evt.data.equals('B'))
        {
            return  new SecondB();
        }
        else
            return null;
    }
    public void doLogic(){};
}

