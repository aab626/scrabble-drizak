package cl.uchile.dcc.scrabble.ast.factory;

import cl.uchile.dcc.scrabble.ast.*;
import cl.uchile.dcc.scrabble.ast.operations.*;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;
import cl.uchile.dcc.scrabble.types.SInt;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class NodeFactoryTest {
    NodeFactory factory;

    private int randomInt1;
    private int randomInt2;
    private boolean randomBoolean1;
    private boolean randomBoolean2;
    private String randomString1;
    private String randomString2;

    private SInt randomSInt1;
    private SInt randomSInt2;
    private SBool randomSBool2;
    private SBool randomSBool1;
    private SString randomSString1;
    private SString randomSString2;

    private NodeExternal nodeNumber1;
    private NodeExternal nodeNumber2;
    private NodeExternal nodeBool1;
    private NodeExternal nodeBool2;
    private NodeExternal nodeString1;
    private NodeExternal nodeString2;

    @BeforeEach
    void setUp(){
        factory = new NodeFactory();

        randomInt1 = RandomUtils.randomInt(0);
        randomInt2 = RandomUtils.randomInt(0);
        randomBoolean1 = RandomUtils.randomBool();
        randomBoolean2 = RandomUtils.randomBool();
        randomString1 = RandomUtils.randomString("");
        randomString2 = RandomUtils.randomString(" ");

        randomSInt1 = new SInt(randomInt1);
        randomSInt2 = new SInt(randomInt2);
        randomSBool1 = new SBool(randomBoolean1);
        randomSBool2 = new SBool(randomBoolean2);
        randomSString1 = new SString(randomString1);
        randomSString2 = new SString(randomString2);

        nodeNumber1 = factory.createExternal();
        nodeNumber1.setValue(new SInt(randomInt1));
        nodeNumber2 = factory.createExternal();
        nodeNumber2.setValue(new SInt(randomInt2));

        nodeBool1 = factory.createExternal();
        nodeBool1.setValue(new SBool(randomBoolean1));
        nodeBool2 = factory.createExternal();
        nodeBool2.setValue(new SBool(randomBoolean2));

        nodeString1 = factory.createExternal();
        nodeString1.setValue(new SString(randomString1));
        nodeString2 = factory.createExternal();
        nodeString2.setValue(new SString(randomString2));
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createAddTest() throws ASTOperationException {
        NodeAdd node = factory.createAdd();
        node.setOperandL(nodeNumber1);
        node.setOperandR(nodeNumber2);

        assertEquals(randomSInt1.add(randomSInt2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createSubtractTest() throws ASTOperationException {
        NodeSubtract node = factory.createSubtract();
        node.setOperandL(nodeNumber1);
        node.setOperandR(nodeNumber2);

        assertEquals(randomSInt1.subtract(randomSInt2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createMultiplyTest() throws ASTOperationException {
        NodeMultiply node = factory.createMultiply();
        node.setOperandL(nodeNumber1);
        node.setOperandR(nodeNumber2);

        assertEquals(randomSInt1.multiply(randomSInt2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createDivideTest() throws ASTOperationException {
        NodeDivide node = factory.createDivide();
        node.setOperandL(nodeNumber1);
        node.setOperandR(nodeNumber2);

        assertEquals(randomSInt1.divide(randomSInt2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createAndTest() throws ASTOperationException {
        NodeAnd node = factory.createAnd();
        node.setOperandL(nodeBool1);
        node.setOperandR(nodeBool2);

        assertEquals(randomSBool1.and(randomSBool2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createOrTest() throws ASTOperationException {
        NodeOr node = factory.createOr();
        node.setOperandL(nodeBool1);
        node.setOperandR(nodeBool2);

        assertEquals(randomSBool1.or(randomSBool2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createNotTest() throws ASTOperationException {
        NodeNot node = factory.createNot();
        node.setOperand(nodeBool1);

        assertEquals(randomSBool1.not(), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createConcatenateTest() throws ASTOperationException {
        NodeConcatenate node = factory.createConcatenate();
        node.setOperandL(nodeString1);
        node.setOperandR(nodeString2);

        assertEquals(randomSString1.concatenateWithSString(randomSString2), node.evaluate());
    }

    @RepeatedTest(value=20, name=RepeatedTest.LONG_DISPLAY_NAME)
    void createExternalTest() throws ASTOperationException {
        NodeExternal node = factory.createExternal();
        node.setValue(randomSInt1);

        assertEquals(randomSInt1, node.evaluate());
    }

}