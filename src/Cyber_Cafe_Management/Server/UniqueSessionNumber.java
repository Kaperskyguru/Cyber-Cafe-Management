package Cyber_Cafe_Management.Server;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UniqueSessionNumber {

    private final static List<Integer> ids = new ArrayList();
    private final static List<Integer> ids1 = new ArrayList();
    private static final int RANGE = 10000, IDRANGE = 90;
    private static int index = 0, index1 = 0;

    static {
        for (int i = 0; i < RANGE; i++) {
            ids.add(i);
        }
        Collections.shuffle(ids);

    }

    static {
        for (int i = 0; i < IDRANGE; i++) {
            ids1.add(i);
        }
        Collections.shuffle(ids1);
    }

    public static int getID() {
        if (index1 > ids1.size() - 1) {

            index1 = 0;
        }
        return ids1.get(index1++);

    }

    private UniqueSessionNumber() {

    }

    public static int getUniqueIDs() {
        if (index > ids.size() - 1) {

            index = 0;
        }
        return ids.get(index++);
    }

    int Random = new Random().nextInt();

    int secureRandom = new SecureRandom().nextInt();

    UUID uuid = UUID.randomUUID();

    //235234ef23-234fsf3-3t2534efr3-34234
}
