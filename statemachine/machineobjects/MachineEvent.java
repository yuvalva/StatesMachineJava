package statemachine.machineobjects;
import java.io.Serializable;
import java.util.Objects;

public class MachineEvent implements Serializable {
    private Object data;
    private String name;

    public MachineEvent(String eventName, Object eventData) {
        this.data = eventData;
        this.name = eventName;
    }

    public Object getData() {return data;}
    public String getName() {return name;}

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MachineEvent)) {
            return false;
        }

        MachineEvent otherEvt = (MachineEvent)o;
        return otherEvt.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
