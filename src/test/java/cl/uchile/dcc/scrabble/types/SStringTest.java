package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {
    private final String STRING_VALUE_FIXED = "fixed_string";
    private SString sStringFixed;

    private String randomString;
    private SString randomSString;

    int randomInt;
    SInt randomSInt;

    double randomDouble;
    SFloat randomSFloat;

    boolean randomBoolean;
    SBool randomSBool;

    String randomBinaryString;
    SBinary randomSBinary;


    @BeforeEach
    void setUp(){
        Random rng = new Random(new Random().nextInt());

        sStringFixed = new SString(STRING_VALUE_FIXED);

        randomString = RandomUtils.randomString(STRING_VALUE_FIXED);
        randomSString = new SString(randomString);

        randomInt = RandomUtils.randomInt(0);
        randomSInt = new SInt(randomInt);

        randomDouble = RandomUtils.randomDouble(0.0);
        randomSFloat = new SFloat(randomDouble);

        randomBoolean = RandomUtils.randomBool();
        randomSBool = new SBool(randomBoolean);

        randomBinaryString = RandomUtils.randomBinaryString("");
        randomSBinary = new SBinary(randomBinaryString);


    }

    @Test
    void constructorStaticTest(){
        assertEquals(new SString(STRING_VALUE_FIXED), sStringFixed);
        assertNotEquals(new SString(STRING_VALUE_FIXED +"!"), sStringFixed);
        assertNotEquals(STRING_VALUE_FIXED, sStringFixed);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void constructorRandomTest(){
        assertNotEquals(randomSString, sStringFixed);
        assertNotEquals(randomString, randomSString);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void toStringTest(){
        assertEquals(randomString, randomSString.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void setStringTest() {
        sStringFixed.setString(randomString);
        assertEquals(randomString, sStringFixed.toString());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void equalsTest(){
        assertEquals(randomSString, new SString(randomString));
        assertNotEquals(sStringFixed, randomSString);
        assertNotEquals(randomString, randomSString);
    }

    @Test
    void hashCodeTest(){
        assertEquals(Objects.hashCode(SString.class), sStringFixed.hashCode());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void copyTest() {
        assertEquals(randomSString, randomSString.copy());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void concatenateTest() {
        assertEquals(new SString(STRING_VALUE_FIXED + randomString), sStringFixed.concatenate(randomSString), "Failed concatenating to SString");
        assertEquals(new SString(STRING_VALUE_FIXED + String.valueOf(randomInt)), sStringFixed.concatenate(randomSInt), "Failed concatenating to SInt");
        assertEquals(new SString(STRING_VALUE_FIXED + String.valueOf(randomDouble)), sStringFixed.concatenate(randomSFloat), "Failed concatenating to SFloat");
        assertEquals(new SString(STRING_VALUE_FIXED + String.valueOf(randomBoolean)), sStringFixed.concatenate(randomSBool), "Failed concatenating to SBool");
        assertEquals(new SString(STRING_VALUE_FIXED + String.valueOf(randomBinaryString)), sStringFixed.concatenate(randomSBinary), "Failed concatenating to SBinary");

    }
}