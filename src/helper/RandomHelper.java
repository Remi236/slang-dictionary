package helper;

import java.util.Random;

public class RandomHelper {
    public static int randomIndexArrayList(int size) {
        Random r = new Random();
        return r.nextInt(size);
    }
}
