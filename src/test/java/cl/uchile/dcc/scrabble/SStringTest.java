package cl.uchile.dcc.scrabble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {
    private final String STRING_VALUE_FIXED = "fixed_string";
    private SString sStringFixed;

    private String randomString;
    private SString randomSString;

    @BeforeEach
    void setUp(){
        Random rng = new Random(new Random().nextInt());

        sStringFixed = new SString(STRING_VALUE_FIXED);

        // Construcción de un SString random distinto al generado por STRING_VALUE_FIXED
        do {
            randomString = RandomStringUtils.random(rng.nextInt(100), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (randomString.equals(STRING_VALUE_FIXED));
        randomSString = new SString(randomString);
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
}