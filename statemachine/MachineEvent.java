package statemachine;

public class MachineEvent<T> {
    T data;
    public MachineEvent(T obj) { this.data = obj;  }
    public T getData() { return data; }
}
