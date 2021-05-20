package cl.uchile.dcc.scrabble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SBoolTest {
    private final boolean VALUE_TRUE = true;
    private final boolean VALUE_FALSE = false;

    private SBool sBoolTrue;
    private SBool sBoolFalse;

    @BeforeEach
    void setUp(){
        sBoolTrue = new SBool(VALUE_TRUE);
        sBoolFalse = new SBool(VALUE_FALSE);
    }

    @Test
    void constructorTest(){
        assertEquals(new SBool(VALUE_TRUE), sBoolTrue);
        assertEquals(new SBool(VALUE_FALSE), sBoolFalse);
    }

    @Test
    void toBoolTest() {
        assertEquals(VALUE_TRUE, sBoolTrue.toBool());
        assertEquals(VALUE_FALSE, sBoolFalse.toBool());
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

    @Test
    void toStringTest(){
        assertEquals(String.valueOf(VALUE_TRUE), sBoolTrue.toString());
        assertEquals(String.valueOf(VALUE_FALSE), sBoolFalse.toString());
    }

    @Test
    void copyTest(){
        assertEquals(sBoolTrue, sBoolTrue.copy());
        assertNotEquals(sBoolFalse, sBoolTrue.copy());

        assertEquals(sBoolFalse, sBoolFalse.copy());
        assertNotEquals(sBoolTrue, sBoolFalse.copy());
    }

    @Test
    void asSStringTest(){
        assertEquals(new SString(String.valueOf(VALUE_TRUE)), sBoolTrue.asSString());
        assertEquals(new SString(String.valueOf(VALUE_FALSE)), sBoolFalse.asSString());
    }


}