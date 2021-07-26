package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeAndTest {
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
    void evaluationTest() throws ASTOperationException {
        NodeAnd node = new NodeAnd(new NodeExternal(SBool1), new NodeExternal(SBool2));
        assertEquals(node.evaluate(),SBool1.and(SBool2));
    }

    @Test
    void exceptionTest() {
        NodeAnd node = new NodeAnd(new NodeExternal(SBool1), new NodeExternal(new SString("nya")));
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}