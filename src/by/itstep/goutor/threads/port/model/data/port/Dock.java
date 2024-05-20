package by.itstep.goutor.threads.port.model.data.port;

public class Dock extends Port {
    private static final int SHIP_COUNT = 1; // max количество кораблей

    private int DockId; // id причала
    private int portRelationship; // id порта к которому относится причал
}
