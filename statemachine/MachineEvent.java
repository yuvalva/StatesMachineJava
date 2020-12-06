package statemachine;
import java.io.Serializable;
import java.util.Objects;

public class MachineEvent implements Serializable {
    private Object data;
    public MachineEvent(Object evtData) { this.data = evtData;  }

    public Object getData() {return data;}
    // Overriding both equals and hashCode enables to compare two states by their data
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MachineEvent)) {
            return false;
        }

        MachineEvent otherEvt = (MachineEvent)o;
        return otherEvt.data.equals(this.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
