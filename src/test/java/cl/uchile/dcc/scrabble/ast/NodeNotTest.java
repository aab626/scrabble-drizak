package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeNotTest {
    private boolean randomBoolean;
    private SBool randomSBool;

    @BeforeEach
    void setUp(){
        randomBoolean = RandomUtils.randomBool();
        randomSBool = new SBool(randomBoolean);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws UnsupportedOperandException {
        NodeNot node = new NodeNot(new NodeExternal(randomSBool));
        assertEquals(node.evaluate(), randomSBool.not());
    }

    @Test
    void exceptionTest() {
        NodeNot node = new NodeNot(new NodeExternal(new SString("nya")));
        assertThrows(UnsupportedOperandException.class, () -> {node.evaluate();});
    }

}