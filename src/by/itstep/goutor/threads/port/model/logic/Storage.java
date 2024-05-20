package by.itstep.goutor.threads.port.model.logic;

import by.itstep.goutor.threads.port.model.data.port.Port;

public class Storage {
    private Port port; // Обьект порта
    private int containerSize; // Кол-во контейнеров
    private int StorageId; // Id склада

    private Thread thread;
    private boolean running;

}
