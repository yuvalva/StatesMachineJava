public class SecondA implements State<Character> {
    public State getNextState(MachineEvent evt)
    {
        if(evt.data.equals('A'))
        {
            return new ThirdConsecuiveEvent();
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
    public void doLogic(){};
}
