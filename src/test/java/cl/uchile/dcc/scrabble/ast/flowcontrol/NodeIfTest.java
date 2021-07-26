package cl.uchile.dcc.scrabble.ast.flowcontrol;

import cl.uchile.dcc.scrabble.ast.ASTree;
import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeIfTest {
    private boolean randomBoolean1;
    private int randomInt1;
    private int randomInt2;

    private SBool sBool1;
    private SInt sInt1;
    private SInt sInt2;

    @BeforeEach
    void setUp(){
        randomBoolean1 = RandomUtils.randomBool();
        randomInt1 = RandomUtils.randomInt(0);
        randomInt2 = RandomUtils.randomInt(randomInt1);

        sBool1 = new SBool(randomBoolean1);
        sInt1 = new SInt(randomInt1);
        sInt2 = new SInt(randomInt2);
    }


    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void evaluationTest() throws ASTOperationException {
        ASTree condition = new ASTree(new NodeExternal(sBool1));
        ASTree astTrue = new ASTree(new NodeExternal(sInt1));
        ASTree astFalse = new ASTree(new NodeExternal(sInt2));

        ASTree ifTree = new ASTree(new NodeIf(condition, astTrue, astFalse));

        if (randomBoolean1){
            assertEquals(sInt1, ifTree.evaluate());
        } else {
            assertEquals(sInt2, ifTree.evaluate());
        }
    }

    @Test
    void exceptionTest() {
        ASTree ast = new ASTree(new NodeExternal(sInt1));
        NodeIf node = new NodeIf(ast, ast, ast);
        assertThrows(ASTOperationException.class, () -> {node.evaluate();});
    }


}