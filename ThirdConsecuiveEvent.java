public class ThirdConsecuiveEvent implements State<Character>{
    ThirdConsecuiveEvent()
    {
        doLogic();
    }
    @Override
    public State getNextState(MachineEvent evt)
    {
        return this;
    }
    @Override
    public void doLogic(){
        System.out.println("Indicated three consecutive events of the same type");
    };
}
