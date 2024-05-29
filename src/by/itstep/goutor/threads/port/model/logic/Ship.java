package by.itstep.goutor.threads.port.model.logic;

import by.itstep.goutor.threads.port.model.data.Container;
import by.itstep.goutor.threads.port.model.data.port.Dock;
import by.itstep.goutor.threads.port.model.data.port.Port;
import by.itstep.goutor.threads.port.util.ContainerFactory;
import by.itstep.goutor.threads.port.util.IDInitializer;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static by.itstep.goutor.threads.port.controller.Main.LOGGER;

public class Ship implements Runnable {
    private int containerSize; // max кол-во контейнеров на корабле
    private int shipId; // id корабля
    private PrintStream stream; // для записи UI
    private Dock dock;


    private Thread thread;
    private boolean running;

    public Ship(Dock dock, PrintStream stream, int shipId) {
        this.dock = dock;
        this.stream = stream;
        this.shipId = shipId;
        running = true;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        while (running) {
            try {
                Container container = ContainerFactory.createContainer();
                dock.put(container);
                stream.printf("Ship id %d delivery container id %d.\n",
                        shipId, container.getContainerId());
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException exception) {
                stream.print(exception);
                LOGGER.error(exception);
            }
        }
    }

    public void stop() {
        running = false;
    }
}
