package cl.uchile.dcc.scrabble.utils;


import cl.uchile.dcc.scrabble.types.SBinary;

import static java.lang.Math.abs;

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

    /**
     * Inverts the bits on a binary string (0s turns to 1s, and vice versa)
     * @param binary binary string to be inverted
     * @return inverted binary string
     */
    public static String invertBinary(String binary) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    /**
     * Operates all bits with a boolean w/r to an AND operator
     * @param binary Binary string
     * @param bool Boolean value to apply the AND with
     * @return Binary string with all bits AND'd to the boolean
     */
    public static String andBinaryWithBool(String binary, boolean bool){
        StringBuilder sb = new StringBuilder();
        boolean bitValue;
        boolean bitResult;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            bitValue = c != '0';
            bitResult = bitValue && bool;

            if (bitResult == true) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    /**
     * Operates all bits with a boolean w/r to an OR operator
     * @param binary Binary string
     * @param bool Boolean value to apply the OR with
     * @return Binary string with all bits OR'd to the boolean
     */
    public static String orBinaryWithBool(String binary, boolean bool){
        StringBuilder sb = new StringBuilder();
        boolean bitValue;
        boolean bitResult;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            bitValue = c != '0';
            bitResult = bitValue || bool;

            if (bitResult == true) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    /**
     * @param binary binary string
     * @return true iff the binary represents a negative number, false otherwise
     */
    public static boolean isNegative(String binary) {
        return BinaryUtils.bitToInt(binary.charAt(0)) != 0;
    }

    /**
     * Fills the binary string to a required length, using 0s if the binary is positive
     * or 1s if negative
     * @param binary Binary string
     * @param length desired length of binary string
     * @return Lengthened binary string
     */
    private static String fillBinary(String binary, int length) {
        String fillBit;
        StringBuilder sb = new StringBuilder();

        if (isNegative(binary)) {
            fillBit = "1";
        } else {
            fillBit = "0";
        }

        int diff = length - binary.length();
        for (int i = 0; i < diff; i++) {
            sb.append(fillBit);
        }

        sb.append(binary);
        return sb.toString();
    }

    /**
     * Matches the length of both binary strings (adding null bits to the shorter one)
     * @param binary1 binary string
     * @param binary2 binary string
     * @return An array of two binary strings
     */
    private static String[] normalizeBinaries(String binary1, String binary2) {
        int length1 = binary1.length();
        int length2 = binary2.length();

        int diff = abs(length1 - length2);
        if (diff > 0) {
            if (length1 < length2) {
                binary1 = fillBinary(binary1, binary1.length() + diff);
            } else {
                binary2 = fillBinary(binary2, binary2.length() + diff);
            }
        }

        return new String[] {binary1, binary2};
    }

    /**
     * Returns the result of AND'ing two binaries
     * @param originalBinary1 Binary string
     * @param originalBinary2 Binary string
     * @return Binary string
     */
    public static String andBinaries(String originalBinary1, String originalBinary2) {
        String [] normalizedBinaries = BinaryUtils.normalizeBinaries(originalBinary1, originalBinary2);
        String binary1 = normalizedBinaries[0];
        String binary2 = normalizedBinaries[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary1.length(); i++) {
            if (binary1.charAt(i) == '1' && binary2.charAt(i) == '1') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    /**
     * Returns the result of OR'ing two binaries
     * @param originalBinary1 Binary string
     * @param originalBinary2 Binary string
     * @return Binary string
     */
    public static String orBinaries(String originalBinary1, String originalBinary2) {
        String [] normalizedBinaries = BinaryUtils.normalizeBinaries(originalBinary1, originalBinary2);
        String binary1 = normalizedBinaries[0];
        String binary2 = normalizedBinaries[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary1.length(); i++) {
            if (binary1.charAt(i) == '0' && binary2.charAt(i) == '0') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();
    }

}
