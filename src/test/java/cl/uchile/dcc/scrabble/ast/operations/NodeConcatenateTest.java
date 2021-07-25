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

class NodeConcatenateTest {
    private String randomString1;
    private String randomString2;

    private SString randomSString1;
    private SString randomSString2;

    @BeforeEach
    void setUp(){
        randomString1 = RandomUtils.randomString("");
        randomString2 = RandomUtils.randomString(" ");

        randomSString1 = new SString(randomString1);
        randomSString2 = new SString(randomString2);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException {
        NodeConcatenate node = new NodeConcatenate(new NodeExternal(randomSString1), new NodeExternal(randomSString2));
        assertEquals(node.evaluate(), randomSString2.concatenate(randomSString1));
    }

    @Test
    void exceptionTest() {
        NodeConcatenate node = new NodeConcatenate(new NodeExternal(randomSString1), new NodeExternal(new SInt(1)));
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}