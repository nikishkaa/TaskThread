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

    public Storage(Port port, PrintStream stream, int storageId, int containerSize) {
        this.port = port;
        this.stream = stream;
        this.storageId = storageId;
        this.containerSize = containerSize;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int containerCount = 0;
        while (running) {
            try {
                containerCount = ++containerCount;
                if (containerCount <= containerSize) {
                    Container container = port.get();
                    stream.printf(" Storage %d use container %d container in storage %d.\n"
                            , storageId, container.getContainerId(), containerCount);
                } else {
                    running = false;
                    stream.printf("Storage %d is full\n", storageId);
                }
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
