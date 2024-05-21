package by.itstep.goutor.threads.port.util;

import java.util.Random;

public class IDInitializer {
    public static final int MAX_CONTAINER_ID = 10_000;
    public static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public static int getContainerID() {

        return RANDOM.nextInt(MAX_CONTAINER_ID);
    }
}
