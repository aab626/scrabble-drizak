package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeOrTest {
    private boolean randomBoolean1;
    private boolean randomBoolean2;

    private SBool SBool1;
    private SBool SBool2;

    @BeforeEach
    void setUp(){
        randomBoolean1 = RandomUtils.randomBool();
        randomBoolean2 = RandomUtils.randomBool();

        SBool1 = new SBool(randomBoolean1);
        SBool2 = new SBool(randomBoolean2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws UnsupportedOperandException {
        NodeOr node = new NodeOr(new NodeExternal(SBool1), new NodeExternal(SBool2));
        assertEquals(node.evaluate(),SBool1.or(SBool2));
    }

    @Test
    void exceptionTest() {
        NodeOr node = new NodeOr(new NodeExternal(SBool1), new NodeExternal(new SString("nya")));
        assertThrows(UnsupportedOperandException.class, () -> {node.evaluate();});
    }

}