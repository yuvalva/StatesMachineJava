public class ThirdConsecuiveEvent implements State<Character>{
    boolean firstTime = true;
    ThirdConsecuiveEvent()
    {
        doLogic();
    }
    public State getNextState(MachineEvent evt)
    {
        return this;
    }
    public void doLogic(){
        if(firstTime)
        {
            System.out.println("Indicated three consecutive events of the same time");
            firstTime = false;
        }
    };
}
