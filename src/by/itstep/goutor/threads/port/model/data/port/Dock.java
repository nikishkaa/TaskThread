package by.itstep.goutor.threads.port.model.data.port;

import by.itstep.goutor.threads.port.model.data.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Dock extends Port {
    private static final int SHIP_COUNT = 1; // max количество кораблей

    private int dockId; // id причала

    private BlockingQueue<Container> queue; // набор контейнеров

    public Dock() {
        queue = new ArrayBlockingQueue<>(1);
    }

    public Dock(int portId, int dockCount, int dockId) {
        super(portId, dockCount);
        this.dockId = dockId;
        queue = new ArrayBlockingQueue<>(1);
    }


    public Container get() throws InterruptedException {
        return queue.take();
    }


    public void put(Container container) throws InterruptedException {
        queue.put(container);
    }
}
