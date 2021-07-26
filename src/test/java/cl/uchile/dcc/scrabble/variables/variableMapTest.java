package cl.uchile.dcc.scrabble.variables;

import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.ast.comparisons.NodeEqual;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class variableMapTest {
    variableMap varMap;

    int randomInt;
    String randomString;

    SInt sInt1;

    @BeforeEach
    void setUp(){
        varMap = variableMap.getInstance();

        randomInt = RandomUtils.randomInt(0);
        randomString = RandomUtils.randomString("");

        sInt1 = new SInt(randomInt);
    }

    @Test
    void singletonTest(){
        assertSame(variableMap.getInstance(), variableMap.getInstance());
    }

    @Test
    void exceptionTest(){
        assertThrows(VariableNotFoundException.class, () -> {varMap.getVar("none");});
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void variableTest() throws VariableNotFoundException {
        varMap.setVar(randomString, sInt1);
        assertSame(sInt1, (SInt) varMap.getVar(randomString));
    }

}