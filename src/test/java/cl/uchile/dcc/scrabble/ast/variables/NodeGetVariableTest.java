package cl.uchile.dcc.scrabble.ast.variables;

import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import cl.uchile.dcc.scrabble.variables.variableMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeGetVariableTest {
    private variableMap varMap;

    private String randomString;
    private int randomInt;

    private SInt sInt1;

    @BeforeEach
    void setUp(){
        varMap = variableMap.getInstance();

        randomString = RandomUtils.randomString("notFoundString");
        randomInt = RandomUtils.randomInt(0);

        sInt1 = new SInt(randomInt);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException {
        NodeGetVariable node = new NodeGetVariable(new NodeExternal(new SString(randomString)));
        varMap.setVar(randomString, sInt1);

        assertEquals(sInt1, node.evaluate());
    }

    @Test
    void exceptionTest() {
        NodeGetVariable node = new NodeGetVariable(new NodeExternal(new SString("notFoundString")));
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}