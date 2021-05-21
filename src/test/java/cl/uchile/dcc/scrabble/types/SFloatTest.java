package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.SFloat;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    private int seed;
    private Random rng;

    private final double DOUBLE_PI = 3.14159265359;
    private SFloat sFloatPi;

    private double randomDouble, randomDouble2;
    private SFloat randomSFloat, randomSFloat2;

    private int randomInt;
    private SInt randomSInt;


    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);

        sFloatPi = new SFloat(DOUBLE_PI);

        randomDouble = RandomUtils.randomDouble(DOUBLE_PI);
        randomDouble2 = RandomUtils.randomDouble(0);

        randomSFloat = new SFloat(randomDouble);
        randomSFloat2 = new SFloat(randomDouble2);

        randomInt = RandomUtils.randomInt(0);
        randomSInt = new SInt(randomInt);
    }

    @Test
    void constructorTest(){
        assertEquals(new SFloat(DOUBLE_PI), sFloatPi);
        assertNotEquals(new SFloat(DOUBLE_PI -1), sFloatPi);
        assertNotEquals(new SFloat((int) DOUBLE_PI), sFloatPi);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void constructorRandomTest(){
        assertNotEquals(randomSFloat, sFloatPi);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toDoubleTest() {
        assertEquals(randomDouble, randomSFloat.toDouble());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void setDoubleTest() {
        sFloatPi.setDouble(randomDouble);
        assertEquals(randomDouble, sFloatPi.toDouble());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void equalsTest() {
        assertTrue(randomSFloat.equals(new SFloat(randomDouble)));
        assertFalse(randomSFloat.equals(sFloatPi));
        assertFalse(randomSFloat.equals(randomDouble));

        assertEquals(new SFloat((int) randomDouble), new SInt((int) randomDouble));
        assertNotEquals(randomSFloat, new SInt((int) randomDouble));
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SFloat.class), sFloatPi.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toStringTest(){
        assertEquals(String.valueOf(randomDouble), randomSFloat.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void copyTest() {
        assertEquals(randomSFloat, randomSFloat.copy());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(randomDouble)), randomSFloat.asSString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void addTest() {
        assertEquals(new SFloat(randomDouble + randomDouble2), randomSFloat.add(randomSFloat2));
        assertEquals(new SFloat(randomDouble + randomInt), randomSFloat.add(randomSInt));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void substractTest() {
        assertEquals(new SFloat(randomDouble - randomDouble2), randomSFloat.substract(randomSFloat2));
        assertEquals(new SFloat(randomDouble - randomInt), randomSFloat.substract(randomSInt));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void multiplyTest() {
        assertEquals(new SFloat(randomDouble * randomDouble2), randomSFloat.multiply(randomSFloat2));
        assertEquals(new SFloat(randomDouble * randomInt), randomSFloat.multiply(randomSInt));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void divideTest() {
        assertEquals(new SFloat(randomDouble / randomDouble2), randomSFloat.divide(randomSFloat2));
        assertEquals(new SFloat(randomDouble / randomInt), randomSFloat.divide(randomSInt));
    }
}