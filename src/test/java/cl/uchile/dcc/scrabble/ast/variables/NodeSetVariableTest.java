package cl.uchile.dcc.scrabble.ast.variables;

import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import cl.uchile.dcc.scrabble.variables.variableMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeSetVariableTest {
    private variableMap varMap;

    private String randomString;
    private int randomInt;

    private SString sString1;
    private SInt sInt1;

    @BeforeEach
    void setUp(){
        varMap = variableMap.getInstance();

        randomString = RandomUtils.randomString("notFoundString");
        randomInt = RandomUtils.randomInt(0);

        sString1 = new SString(randomString);
        sInt1 = new SInt(randomInt);
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException, VariableNotFoundException {
        NodeExternal nodeName = new NodeExternal(sString1);
        NodeExternal nodeValue = new NodeExternal(sInt1);
        NodeSetVariable node = new NodeSetVariable(nodeName, nodeValue);

        node.evaluate();

        assertEquals(sInt1, varMap.getVar(randomString));
    }

    @Test
    void exceptionTest() {
        NodeExternal nodeName = new NodeExternal(sInt1);
        NodeExternal nodeValue = new NodeExternal(sInt1);
        NodeSetVariable node = new NodeSetVariable(nodeName, nodeValue);
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }

}