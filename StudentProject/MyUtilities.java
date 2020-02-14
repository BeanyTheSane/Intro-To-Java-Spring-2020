import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyUtilities {

    public static String getRandomStringFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String[] addItemToArray(String initialArray[], String itemToAdd) {
        String newArray[] = new String[initialArray.length + 1];

        for (int i = 0; i < initialArray.length; i++) {
            newArray[i] = initialArray[i];
        }

        newArray[initialArray.length] = itemToAdd;

        return newArray;
    }

    public static boolean continueProcess(String input) {
        if (input.equals("")) {
            return true;
        }
        return false;
    }

    //generates a random number of the given length
    public static Long generateRandomNumber(int length) {
        long min = (long) Math.pow(10, length - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }
}