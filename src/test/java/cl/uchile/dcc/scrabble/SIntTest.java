package cl.uchile.dcc.scrabble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    private int seed;
    private Random rng;

    private final int INT_28 = 28;
    private SInt sInt28;

    private int randomInt;
    private SInt randomSInt;

    private double randomDouble;


    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);

        sInt28 = new SInt(INT_28);

        // Genera un int al azar distinto de INT_28
        do {
            randomInt = rng.nextInt();
        } while(randomInt == INT_28);
        randomSInt = new SInt(randomInt);

        do {
            randomDouble = rng.nextDouble();
        } while (randomDouble == (double) INT_28);
    }

    @Test
    void constructorTest(){
        assertEquals(new SInt(INT_28), sInt28);
        assertNotEquals(new SInt(INT_28 -1), sInt28);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void constructorRandomTest(){
        assertNotEquals(randomSInt, sInt28);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toIntTest(){
        assertEquals(randomInt, randomSInt.toInt());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void setIntTest() {
        sInt28.setInt(randomInt);
        assertEquals(randomInt, sInt28.toInt());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void equalsTest(){
        assertTrue(randomSInt.equals(new SInt(randomInt)));
        assertFalse(randomSInt.equals(sInt28));
        assertFalse(randomSInt.equals(randomInt));

        assertEquals(randomSInt, new SFloat((double) randomInt));
        assertNotEquals(randomSInt, new SFloat(randomDouble));
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SInt.class), sInt28.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toStringTest(){
        assertEquals(String.valueOf(randomInt), randomSInt.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(randomInt)), randomSInt.asSString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSFloatTest(){
        assertEquals(new SFloat((double) randomInt), randomSInt.asSFloat());
    }

}