package cl.uchile.dcc.scrabble.types.factory;

import cl.uchile.dcc.scrabble.types.*;
import cl.uchile.dcc.scrabble.utils.BinaryUtils;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class FlyweightFactoryTest {
    private FlyweightFactory factory;

    private int randomInt;
    private double randomDouble;
    private String randomString;
    private boolean randomBoolean;

    private SInt randomSInt1;
    private SInt randomSInt2;

    private SBinary randomSBinary1;
    private SBinary randomSBinary2;

    private SBool randomSBool1;
    private SBool randomSBool2;

    private SFloat randomSFloat1;
    private SFloat randomSFloat2;

    private SString randomSString1;
    private SString randomSString2;

    @BeforeEach
    void setUp() {
        factory = new FlyweightFactory();

        randomInt = RandomUtils.randomInt(0);
        randomDouble = RandomUtils.randomDouble(0);
        randomString = RandomUtils.randomString("");
        randomBoolean = RandomUtils.randomBool();
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSIntTest(){
        randomSInt1 = factory.createSInt(randomInt);
        randomSInt2 = factory.createSInt(randomInt);
        assertSame(randomSInt1, randomSInt2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSBinaryTest(){
        randomSBinary1 = factory.createSBinary(BinaryUtils.intToBinary(randomInt));
        randomSBinary2 = factory.createSBinary(BinaryUtils.intToBinary(randomInt));
        assertSame(randomSBinary1, randomSBinary2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSBoolTest(){
        randomSBool1 = factory.createSBool(randomBoolean);
        randomSBool2 = factory.createSBool(randomBoolean);
        assertSame(randomSBool1, randomSBool2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSFloatTest(){
        randomSFloat1 = factory.createSFloat(randomDouble);
        randomSFloat2 = factory.createSFloat(randomDouble);
        assertSame(randomSFloat1, randomSFloat2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSStringTest(){
        randomSString1 = factory.createSString(randomString);
        randomSString2 = factory.createSString(randomString);
        assertSame(randomSString1, randomSString2);
    }


}