package by.itstep.goutor.threads.port.model.logic;

import by.itstep.goutor.threads.port.model.data.Container;
import by.itstep.goutor.threads.port.model.data.port.Port;

import java.io.PrintStream;

import static by.itstep.goutor.threads.port.controller.Main.LOGGER;

public class Storage implements Runnable {
    private Port port; // Обьект порта
    private int containerSize; // Кол-во контейнеров
    private int storageId; // Id склада
    private PrintStream stream;

    private Thread thread;
    private boolean running;

    public Storage(Port port, PrintStream stream, int storageId) {
        this.port = port;
        this.stream = stream;
        this.storageId = storageId;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Container container = port.get();
                stream.printf(" Storage %d use container %d.\n", storageId, container.getContainerId());
            } catch (InterruptedException exception) {
                stream.print(exception);
                LOGGER.warn(exception);
            }


        }
    }


    public void stop() {
        running = false;
    }
}
