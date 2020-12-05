public interface State<T> {
    public State getNextState(MachineEvent<T> evt);
    public void doLogic();
}
