package by.itstep.goutor.threads.port.model.data.port;

import by.itstep.goutor.threads.port.model.data.Container;

import java.util.concurrent.BlockingQueue;

public class Dock extends Port {
    private static final int SHIP_COUNT = 1; // max количество кораблей

    private int dockId; // id причала
    private int portRelationship; // id порта к которому относится причал

    public Dock(int portId, int dockCount, BlockingQueue<Container> queue, int dockId, int portRelationship) {
        super(portId, dockCount, queue);
        this.dockId = dockId;
        this.portRelationship = portRelationship;
    }

    public int getDockId() {
        return dockId;
    }

    public void setDockId(int dockId) {
        this.dockId = dockId;
    }

    public int getPortRelationship() {
        return portRelationship;
    }

    public void setPortRelationship(int portRelationship) {
        this.portRelationship = portRelationship;
    }
}
