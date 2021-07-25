package cl.uchile.dcc.scrabble.ast.flowcontrol;

import cl.uchile.dcc.scrabble.ast.ASTree;
import cl.uchile.dcc.scrabble.ast.NodeExternal;
import cl.uchile.dcc.scrabble.ast.comparisons.NodeGreater;
import cl.uchile.dcc.scrabble.ast.comparisons.NodeNotEqual;
import cl.uchile.dcc.scrabble.ast.operations.NodeSubtract;
import cl.uchile.dcc.scrabble.ast.variables.NodeGetVariable;
import cl.uchile.dcc.scrabble.ast.variables.NodeSetVariable;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.variables.variableMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NodeWhileTest {
    private variableMap varMap;

    private SString sStringA;
    private SString sStringB;

    private NodeExternal nodeStrA;
    private NodeExternal nodeStrB;

    private NodeGetVariable nodeGetA;
    private NodeGetVariable nodeGetB;

    private NodeExternal nodeZero;

    int gcd;

    @BeforeEach
    void setUp(){
    sStringA = new SString("a");
    sStringB = new SString("b");

    nodeStrA = new NodeExternal(sStringA);
    nodeStrB = new NodeExternal(sStringB);

    nodeGetA = new NodeGetVariable(nodeStrA);
    nodeGetB = new NodeGetVariable(nodeStrB);

    nodeZero = new NodeExternal(new SInt(0));

    Random rng = new Random();
    int intA = 1 + rng.nextInt(100);
    int intB = 1 + rng.nextInt(100);

    varMap = variableMap.getInstance();
    varMap.setVar("a", new SInt(intA));
    varMap.setVar("b", new SInt(intB));

    while (intB != 0){
        if (intA > intB) {
            intA = intA - intB;
        } else {
            intB = intB - intA;
        }
    }

    gcd = intB;

    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void euclidesAlgorithmTest() throws ASTOperationException {
        ASTree astIfCondition =  new ASTree(new NodeGreater(nodeGetA, nodeGetB));
        ASTree astIfTrue = new ASTree(new NodeSetVariable(nodeStrA, new NodeSubtract(nodeGetA, nodeGetB)));
        ASTree astIfFalse = new ASTree(new NodeSetVariable(nodeStrB, new NodeSubtract(nodeGetB, nodeGetA)));

        ASTree astWhileTrue = new ASTree(new NodeIf(astIfCondition, astIfTrue, astIfFalse));
        ASTree astWhileCondition = new ASTree(new NodeNotEqual(nodeGetB, nodeZero));

        ASTree astEuclides = new ASTree(new NodeWhile(astWhileCondition, astWhileTrue));
        astEuclides.evaluate();

        assertEquals(new SInt(gcd), nodeGetB.evaluate());
    }

}