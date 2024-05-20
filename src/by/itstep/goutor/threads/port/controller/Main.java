package by.itstep.goutor.threads.port.controller;

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

        Port port = new Port();
        Ship ship1 = new Ship(port, System.out, 1000);
        Ship ship2 = new Ship(port, System.out, 2000);


        Storage storage1 = new Storage(port, System.out, 10);
        Storage storage2 = new Storage(port, System.out, 20);


        TimeUnit.SECONDS.sleep(10);
        ship1.stop();
        ship2.stop();
        storage1.stop();
        storage2.stop();

    }
}
