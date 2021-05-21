package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.BinaryUtils;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SBoolTest {
    private final boolean VALUE_TRUE = true;
    private final boolean VALUE_FALSE = false;

    private SBool sBoolTrue;
    private SBool sBoolFalse;

    private boolean randomBoolean, randomBoolean2;
    private SBool randomSBool, randomSBool2;

    private String randomBinaryString;
    private SBinary randomSBinary;

    @BeforeEach
    void setUp(){
        sBoolTrue = new SBool(VALUE_TRUE);
        sBoolFalse = new SBool(VALUE_FALSE);

        randomBoolean = RandomUtils.randomBool();
        randomBoolean2 = RandomUtils.randomBool();

        randomSBool = new SBool(randomBoolean);
        randomSBool2 = new SBool(randomBoolean2);

        randomBinaryString = RandomUtils.randomBinaryString("");
        randomSBinary = new SBinary(randomBinaryString);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void constructorTest(){
        assertEquals(new SBool(randomBoolean), randomSBool);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toBoolTest() {
        assertEquals(randomBoolean, randomSBool.toBool());
    }

    @Test
    void setBoolTest() {
        sBoolTrue.setBool(VALUE_FALSE);
        assertEquals(VALUE_FALSE, sBoolTrue.toBool());
    }

    @Test
    void equalsTest() {
        assertNotEquals(new SBool(VALUE_FALSE), sBoolTrue);
        assertNotEquals(new SBool(VALUE_TRUE), sBoolFalse);

        assertFalse(sBoolTrue.equals(VALUE_TRUE));
        assertFalse(sBoolTrue.equals(VALUE_FALSE));
        assertFalse(sBoolFalse.equals(VALUE_TRUE));
        assertFalse(sBoolFalse.equals(VALUE_FALSE));
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SBool.class), sBoolTrue.hashCode());
        assertEquals(Objects.hashCode(SBool.class), sBoolFalse.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toStringTest(){
        assertEquals(String.valueOf(randomBoolean), randomSBool.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void copyTest(){
        assertEquals(randomSBool, randomSBool.copy());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(randomBoolean)), randomSBool.asSString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void notTest() {
        assertEquals(new SBool(!randomBoolean), randomSBool.not());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void andTest() {
        assertEquals(new SBool(randomBoolean && randomBoolean2), randomSBool.and(randomSBool2));
        assertEquals(new SBinary(BinaryUtils.andBinaryWithBool(randomBinaryString, randomBoolean)), randomSBool.and(randomSBinary));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void orTest() {
        assertEquals(new SBool(randomBoolean || randomBoolean2), randomSBool.or(randomSBool2));
        assertEquals(new SBinary(BinaryUtils.orBinaryWithBool(randomBinaryString, randomBoolean)), randomSBool.or(randomSBinary));
    }


}