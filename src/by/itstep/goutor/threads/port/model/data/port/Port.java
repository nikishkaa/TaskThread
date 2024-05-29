package by.itstep.goutor.threads.port.model.data.port;

import by.itstep.goutor.threads.port.model.data.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Port {
    private int PortId; // id порта
    private int dockCount; // кол-во причалов


    public Port() {

    }

    public Port(int portId, int dockCount) {
        this.PortId = portId;
        this.dockCount = dockCount;
    }


    public int getPortId() {
        return PortId;
    }

    public int getDockCount() {
        return dockCount;
    }
}
