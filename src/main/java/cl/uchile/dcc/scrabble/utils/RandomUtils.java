package cl.uchile.dcc.scrabble.utils;

import cl.uchile.dcc.scrabble.types.SBinary;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/** Class to store various utility methods to generate random values, mainly aimed to tests */
public class RandomUtils {
    private static final char[] BINARY_CHARS = "01".toCharArray();
    private static final char[] NONBINARY_CHARS = "23456789".toCharArray();

    /**
     * Generates a random integer different to an specific one
     * @param excludedInt integer to exclude from randomization
     * @return random integer
     */
    public static int randomInt(int excludedInt) {
        Random rng = generateRNG();
        int randomInt = 0;
        do {
            randomInt = rng.nextInt();
        } while (randomInt == excludedInt);

        return randomInt;
    }

    /** @return a brand new random number generator */
    private static Random generateRNG() {
        return new Random(new Random().nextInt());
    }

    /**
     * Generates a random double different to an specific one
     * @param excludedDouble double to exclude from randomization
     * @return random double
     */
    public static double randomDouble(double excludedDouble) {
        Random rng = generateRNG();
        double randomDouble = 0.0;
        do {
            randomDouble = rng.nextDouble();
        } while (randomDouble == excludedDouble);

        return randomDouble;
    }

    /** @return a random boolean */
    public static boolean randomBool() {
        Random rng = generateRNG();
        int c = rng.nextInt(2);
        return c != 0;
    }

    /**
     * Generates a random binary string different to an specific one
     * @param excludedBinaryString binary string to exclude from randomization
     * @return random binary string of 1 to 32 bits
     */
    public static String randomBinaryString(int excludedBinaryAsInt) {
        Random rng = generateRNG();
        String randomBinaryString;
        int strSize = rng.nextInt(32-1)+1;

        do {
            StringBuilder sb = new StringBuilder(strSize);
            for (int i = 0; i < strSize; i++) {
                char bit = BINARY_CHARS[rng.nextInt(BINARY_CHARS.length)];
                sb.append(bit);
            }
            randomBinaryString = sb.toString();
        } while (BinaryUtils.toInt(randomBinaryString) == excludedBinaryAsInt);

        return randomBinaryString;
    }

    /**
     * Generates a random non binary string using digits from 2 to 9
     * @return random non binary string of length from 1 to 32
     */
    public static String randomNonBinaryString() {
        Random rng = generateRNG();
        String randomNonBinaryString;
        int strSize = rng.nextInt(32-1)+1;

        StringBuilder sb = new StringBuilder(strSize);
        for (int i = 0; i < strSize; i++) {
            char bit = NONBINARY_CHARS[rng.nextInt(NONBINARY_CHARS.length)];
            sb.append(bit);
        }

        randomNonBinaryString = sb.toString();
        return randomNonBinaryString;
    }

    /**
     * Generates a random string different to an specific one
     * @param excludedString string to exclude from randomization
     * @return random string
     */
    public static String randomString(String excludedString) {
        Random rng = generateRNG();
        String randomString;

        do {
            randomString = RandomStringUtils.random(rng.nextInt(100), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (randomString.equals(excludedString));

        return randomString;
    }
}
