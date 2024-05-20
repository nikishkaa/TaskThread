package by.itstep.goutor.threads.port.model.logic;

import java.io.PrintStream;

public class Ship {
    private int containerSize; // max кол-во контейнеров на корабле
    private int ShipId; // id корабля
    private PrintStream stream; // для записи UI

    private Thread thread;
    private boolean running;
}
