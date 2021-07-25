package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeSubtractTest {
    private int randomInt1;
    private int randomInt2;

    private SInt randomSInt1;
    private SInt randomSInt2;

    @BeforeEach
    void setUp(){
        randomInt1 = RandomUtils.randomInt(0);
        randomInt2 = RandomUtils.randomInt(0);

        randomSInt1 = new SInt(randomInt1);
        randomSInt2 = new SInt(randomInt2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException {
        NodeSubtract node = new NodeSubtract(new NodeExternal(randomSInt1), new NodeExternal(randomSInt2));
        assertEquals(node.evaluate(),randomSInt1.subtract(randomSInt2));
    }

    @Test
    void exceptionTest() {
        NodeSubtract node = new NodeSubtract(new NodeExternal(randomSInt1), new NodeExternal(new SString("nya")));
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}