package by.itstep.goutor.threads.port.util;

import by.itstep.goutor.threads.port.model.data.Container;

public class ContainerFactory {
    public static Container createContainer() {

        int id = IDInitializer.getContainerID();

        Container container = new Container(id);

        return container;
    }
}
