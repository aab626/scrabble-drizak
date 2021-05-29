package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    private SBinary sBinary150;
    private SBinary sBinary52;
    private SBinary randomSBinary, randomSBinary2;
    private final String SBINARY_VALUE_150 = "010010110";
    private final String SBINARY_VALUE_52 = "00110100";
    private String randomBinaryString, randomBinaryString2;

    private boolean randomBoolean;
    private SBool randomSBool;

    private int randomInt;
    private SInt randomSInt;

    private double randomDouble;
    private SFloat randomSFloat;

    @BeforeEach
    void setUp(){
        sBinary150 = new SBinary(SBINARY_VALUE_150);
        sBinary52 = new SBinary(SBINARY_VALUE_52);

        randomBinaryString = RandomUtils.randomBinaryString(150);
        randomSBinary = new SBinary(randomBinaryString);

        randomBinaryString2 = RandomUtils.randomBinaryString(0);
        randomSBinary2 = new SBinary(randomBinaryString2);

        randomBoolean = RandomUtils.randomBool();
        randomSBool = new SBool(randomBoolean);

        randomInt = RandomUtils.randomInt(0);
        randomSInt = new SInt(randomInt);

        randomDouble = 1 + RandomUtils.randomDouble(0.0);
        randomSFloat = new SFloat(randomDouble);
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

        assertTrue(randomSBinary.equals(randomSBinary.asSInt()));
        assertTrue(randomSBinary.equals(randomSBinary.asSFloat()));
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SBinary.class), sBinary52.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void copyTest(){
        assertEquals(new SBinary(randomBinaryString), (new SBinary(randomBinaryString)).copy());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(randomBinaryString), randomSBinary.asSString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSFloatTest() {
        assertEquals(new SFloat(BinaryUtils.toInt(randomBinaryString)), (new SBinary(randomBinaryString)).asSFloat());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSIntTest() {
        assertEquals(new SInt(BinaryUtils.toInt(randomBinaryString)), (new SBinary(randomBinaryString)).asSInt());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void addTest() {
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) + randomInt)), randomSBinary.add(randomSInt));
        assertEquals(new SFloat(BinaryUtils.toInt(randomBinaryString) + randomDouble), randomSBinary.add(randomSFloat));
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) + BinaryUtils.toInt(randomBinaryString2))), randomSBinary.add(randomSBinary2));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void subtractTest() {
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) - randomInt)), randomSBinary.subtract(randomSInt));
        assertEquals(new SFloat(BinaryUtils.toInt(randomBinaryString) - randomDouble), randomSBinary.subtract(randomSFloat));
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) - BinaryUtils.toInt(randomBinaryString2))), randomSBinary.subtract(randomSBinary2));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void multiplyTest() {
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) * randomInt)), randomSBinary.multiply(randomSInt));
        assertEquals(new SFloat(BinaryUtils.toInt(randomBinaryString) * randomDouble), randomSBinary.multiply(randomSFloat));
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) * BinaryUtils.toInt(randomBinaryString2))), randomSBinary.multiply(randomSBinary2));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void divideTest() {
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) / randomInt)), randomSBinary.divide(randomSInt));
        assertEquals(new SFloat(BinaryUtils.toInt(randomBinaryString) / randomDouble), randomSBinary.divide(randomSFloat));
        assertEquals(new SBinary(BinaryUtils.intToBinary(BinaryUtils.toInt(randomBinaryString) / BinaryUtils.toInt(randomBinaryString2))), randomSBinary.divide(randomSBinary2));
    }


    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void notTest() {
        assertEquals(new SBinary(BinaryUtils.invertBinary(randomBinaryString)), (new SBinary(randomBinaryString)).not());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void andTest() {
        assertEquals(new SBinary(BinaryUtils.andBinaryWithBool(randomBinaryString, randomBoolean)), randomSBinary.and(randomSBool));
        assertEquals(new SBinary(BinaryUtils.andBinaries(randomBinaryString, randomBinaryString2)), randomSBinary.and(randomSBinary2));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void orTest() {
        assertEquals(new SBinary(BinaryUtils.orBinaryWithBool(randomBinaryString, randomBoolean)), randomSBinary.or(randomSBool));
        assertEquals(new SBinary(BinaryUtils.orBinaries(randomBinaryString, randomBinaryString2)), randomSBinary.or(randomSBinary2));
    }

}