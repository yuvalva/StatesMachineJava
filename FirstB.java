public class FirstB implements State<Character> {
    @Override
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
    @Override
    public void doLogic(){};
}

