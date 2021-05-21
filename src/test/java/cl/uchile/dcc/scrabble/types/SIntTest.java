package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
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

    private int randomInt, randomInt2;
    private SInt randomSInt, randomSInt2;

    private double randomDouble;
    private SFloat randomSFloat;

    private String randomBinaryString;
    private SBinary randomSBinary;



    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);

        sInt28 = new SInt(INT_28);

        randomInt = RandomUtils.randomInt(INT_28);
        randomSInt = new SInt(randomInt);

        randomInt2 = RandomUtils.randomInt(0);
        randomSInt2 = new SInt(randomInt2);

        randomDouble = RandomUtils.randomDouble((double) INT_28);
        randomSFloat = new SFloat(randomDouble);

        randomBinaryString = RandomUtils.randomBinaryString(0);
        randomSBinary = new SBinary(randomBinaryString);

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
    void copyTest() {
        assertEquals(randomSInt, randomSInt.copy());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(randomInt)), randomSInt.asSString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSFloatTest(){
        assertEquals(new SFloat((double) randomInt), randomSInt.asSFloat());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSBinaryTest() {
        assertEquals(new SBinary(BinaryUtils.intToBinary(randomInt)), randomSInt.asSBinary());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void addTest() {
        assertEquals(new SInt(randomInt + randomInt2), randomSInt.add(randomSInt2));
        assertEquals(new SFloat(randomInt + randomDouble), randomSInt.add(randomSFloat));
        assertEquals(new SInt(randomInt + BinaryUtils.toInt(randomBinaryString)), randomSInt.add(randomSBinary));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void substractTest() {
        assertEquals(new SInt(randomInt - randomInt2), randomSInt.subtract(randomSInt2));
        assertEquals(new SFloat(randomInt - randomDouble), randomSInt.subtract(randomSFloat));
        assertEquals(new SInt(randomInt - BinaryUtils.toInt(randomBinaryString)), randomSInt.subtract(randomSBinary));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void multiplyTest() {
        assertEquals(new SInt(randomInt * randomInt2), randomSInt.multiply(randomSInt2));
        assertEquals(new SFloat(randomInt * randomDouble), randomSInt.multiply(randomSFloat));
        assertEquals(new SInt(randomInt * BinaryUtils.toInt(randomBinaryString)), randomSInt.multiply(randomSBinary));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void divideTest() {
        assertEquals(new SInt(randomInt / randomInt2), randomSInt.divide(randomSInt2));
        assertEquals(new SFloat(randomInt / randomDouble), randomSInt.divide(randomSFloat));
        assertEquals(new SInt(randomInt / BinaryUtils.toInt(randomBinaryString)), randomSInt.divide(randomSBinary));
    }


}