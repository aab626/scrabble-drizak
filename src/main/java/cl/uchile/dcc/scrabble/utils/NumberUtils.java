package cl.uchile.dcc.scrabble.utils;

public class NumberUtils {
    public static int compareTo(double a, double b) {
        if (a > b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}
