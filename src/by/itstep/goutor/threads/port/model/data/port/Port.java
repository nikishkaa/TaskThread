package by.itstep.goutor.threads.port.model.data.port;

import by.itstep.goutor.threads.port.model.data.Container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Port {
    private int PortId; // id порта
    private int dockCount; // кол-во причалов
    private BlockingQueue<Container> queue; // набор контейнеров

    public Port() {
        queue = new ArrayBlockingQueue<>(1);
    }

    public Port(int portId, int dockCount, BlockingQueue<Container> queue) {
        this.PortId = portId;
        this.dockCount = dockCount;
        this.queue = queue;
    }

    public Container get() throws InterruptedException {
        return queue.take();
    }


    public void put(Container container) throws InterruptedException {
        queue.put(container);
    }
}
