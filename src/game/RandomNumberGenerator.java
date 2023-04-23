package game;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }

    /**
     * A die which returns True chance% of the time, otherwise False
     * @param chance an integer between 0-100 representing the %chance of an occurrence
     * @return True chance% of the time, otherwise False
     */
    public static boolean getRandomChance(int chance){
        int result = getRandomInt(100);
        return result <= chance;
    }
}
