import java.util.Random;

public class MyUtilities {

    public static String getRandomStringFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
