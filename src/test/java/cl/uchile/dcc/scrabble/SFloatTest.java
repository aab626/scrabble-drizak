package cl.uchile.dcc.scrabble;

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

    private double randomDouble;
    private SFloat randomSFloat;


    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);

        sFloatPi = new SFloat(DOUBLE_PI);

        // Genera un double al azar distinto de DOUBLE_PI
        do {
            randomDouble = rng.nextDouble();
        } while(randomDouble == DOUBLE_PI);
        randomSFloat = new SFloat(randomDouble);
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
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(randomDouble)), randomSFloat.asSString());
    }
}