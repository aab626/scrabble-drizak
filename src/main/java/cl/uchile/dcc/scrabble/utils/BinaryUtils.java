package cl.uchile.dcc.scrabble.utils;


/** Class to store various utility methods related to SBinary operations */
public class BinaryUtils {

    /**
     * Provided by CC3002 Coordination
     * Transforms a BinaryString to an integer
     * @param binary Binary string
     * @return the integer that the binaryString represents
     */
    public static int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Provided by CC3002 Coordination
     * Complementary to toInt, when the binary is a negative number
     * @param binary Binary string
     * @return the integer that the binaryString represents
     */
    private static int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /**
     * Provided by CC3002 Coordination
     * Complementary to toInt, when the binary is a positive number
     * @param binary Binary string
     * @return the integer that the binaryString represents
     */
    private static int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Provided by CC3002 Coordination
     * Complementary to toInt, gets the decimal value of a bit in a given binary string.
     * @param bit binary bit
     * @return integer value of said bit
     */
    private static int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

}
