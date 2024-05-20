package by.itstep.goutor.threads.port.model.data.port;

import by.itstep.goutor.threads.port.model.data.Container;

import java.util.concurrent.BlockingQueue;

public class Port {
    private int PortId; // id порта
    private int dockCount; // кол-во причалов
    private BlockingQueue<Container> queue; // набор контейнеров


}
