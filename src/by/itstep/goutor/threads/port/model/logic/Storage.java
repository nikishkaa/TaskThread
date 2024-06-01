package by.itstep.goutor.threads.port.model.logic;

import by.itstep.goutor.threads.port.model.data.Container;
import by.itstep.goutor.threads.port.model.data.port.Dock;
import by.itstep.goutor.threads.port.model.data.port.Port;

import java.io.PrintStream;

import static by.itstep.goutor.threads.port.controller.Main.LOGGER;

public class Storage implements Runnable {
    private Dock dock; // Обьект порта
    private int containerSize; // Кол-во контейнеров
    private int storageId; // Id склада
    private PrintStream stream;

    private Thread thread;
    private boolean running;

    // Реализовать метод рабочего который будет перекладывать всё на склад а в складе сделать метод пут и гет


    public Storage(Dock dock, PrintStream stream, int storageId, int containerSize) {
        this.dock = dock;
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
                    Container container = dock.get();
                    stream.printf(" Storage %d use container %d. containers in storage %d.\n"
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
