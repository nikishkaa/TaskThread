package by.itstep.goutor.threads.port.controller;

import by.itstep.goutor.threads.port.model.data.port.Dock;
import by.itstep.goutor.threads.port.model.data.port.Port;
import by.itstep.goutor.threads.port.model.logic.Ship;
import by.itstep.goutor.threads.port.model.logic.Storage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Main {
    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        LOGGER.setLevel(Level.ALL);

        Port port = new Port(1, 2);
        Dock dock = new Dock(port.getPortId(), port.getDockCount(), 1);

        Port port2 = new Port(2, 10);
        Dock dock2 = new Dock(port2.getPortId(), port2.getDockCount(), 2);


        Ship ship1 = new Ship(dock, System.out, 1000);
        Ship ship2 = new Ship(dock, System.out, 2000);
        Storage storage1 = new Storage(dock, System.out, 10, 1);
        Storage storage2 = new Storage(dock, System.out, 20, 5);

        TimeUnit.SECONDS.sleep(10);
        ship1.stop();
        ship2.stop();
        storage1.stop();
        storage2.stop();

    }
}
