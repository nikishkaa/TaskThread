package by.itstep.goutor.threads.port.model.data;

public class Container {
    private int containerId;

    public Container(int containerId) {
        this.containerId = containerId;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    @Override
    public String toString() {
        return "Container ID" + containerId;
    }
}
