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

class NodeNotTest {
    private boolean randomBoolean;
    private SBool randomSBool;

    @BeforeEach
    void setUp(){
        randomBoolean = RandomUtils.randomBool();
        randomSBool = new SBool(randomBoolean);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException {
        NodeNot node = new NodeNot(new NodeExternal(randomSBool));
        assertEquals(node.evaluate(), randomSBool.not());
    }

    @Test
    void exceptionTest() {
        NodeNot node = new NodeNot(new NodeExternal(new SString("nya")));
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}