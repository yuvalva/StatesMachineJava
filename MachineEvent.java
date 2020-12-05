public class MachineEvent<T> {
    T data;
    MachineEvent(T obj) { this.data = obj;  }
    public T getData() { return data; }
}
