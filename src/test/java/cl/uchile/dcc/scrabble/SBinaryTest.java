package cl.uchile.dcc.scrabble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    private int seed;
    private Random rng;

    private SBinary sBinary150;
    private SBinary sBinary52;
    private SBinary randomSBinary;
    private final String SBINARY_VALUE_150 = "10010110";
    private final String SBINARY_VALUE_52 = "00110100";
    private String randomBinaryString;
    private String randomNonBinaryString;
    private final char[] BINARY_CHARS = "01".toCharArray();
    private final char[] NONBINARY_CHARS = "23456789".toCharArray();

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);

        sBinary150 = new SBinary(SBINARY_VALUE_150);
        sBinary52 = new SBinary(SBINARY_VALUE_52);

        // Construir un string random de 8 caracteres compuesto por 0s y 1s, distinto de SBINARY_VALUE_150
        int strSize = rng.nextInt(8-1)+1;

        do {
            StringBuilder sb = new StringBuilder(strSize);
            for (int i = 0; i < strSize; i++) {
                char bit = BINARY_CHARS[rng.nextInt(BINARY_CHARS.length)];
                sb.append(bit);
            }
            randomBinaryString = sb.toString();
        } while (randomBinaryString.equals(SBINARY_VALUE_150));
        randomSBinary = new SBinary(randomBinaryString);

        // Construir un string random de 8 caracteres compuesto por cualquier cualquier digito excepto 0 y 1
        StringBuilder sb = new StringBuilder(strSize);
        for (int i = 0; i < strSize; i++) {
            char bit = NONBINARY_CHARS[rng.nextInt(NONBINARY_CHARS.length)];
            sb.append(bit);
        }
        randomNonBinaryString = sb.toString();

    }

    @Test
    void constructorTest(){
        assertEquals(new SBinary(SBINARY_VALUE_52), sBinary52);
        assertEquals(new SBinary(SBINARY_VALUE_150), sBinary150);
        assertNotEquals(sBinary52, sBinary150);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toStringTest(){
        assertEquals(randomBinaryString, randomSBinary.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void setStringTest() {
        sBinary52.setString(randomBinaryString);
        assertEquals(randomBinaryString, sBinary52.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void equalsTest() {
        assertTrue(randomSBinary.equals(new SBinary(randomBinaryString)));
        assertFalse(randomSBinary.equals(sBinary150));
        assertFalse(randomSBinary.equals(randomBinaryString));
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SBinary.class), sBinary52.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(randomBinaryString), randomSBinary.asSString());

    }
}