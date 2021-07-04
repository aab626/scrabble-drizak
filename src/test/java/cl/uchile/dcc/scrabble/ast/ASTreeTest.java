package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ASTreeTest {
    private ASTree ast;

    @Test
    void nullASTTest() {
        NodeExternal n1 = new NodeExternal(new SInt(10));
        NodeExternal n2 = new NodeExternal(new SString("nya"));
        NodeAdd node = new NodeAdd(n1, n2);

        ast = new ASTree(node);
        assertEquals(ast.evaluate(), null);
    }

    /**
     * This test constructs and evaluates an AST that can be found here
     * /scrabble-drizak/diagrams/Tarea 2/AST_Test.png
     */
    @Test
    void AddTreeTest() {
        // node construction, bottom-up
        NodeExternal l51 = new NodeExternal(new SBool(true));

        NodeExternal l41 = new NodeExternal(new SBinary("100"));
        NodeNot l42 = new NodeNot(l51);
        NodeExternal l43 = new NodeExternal(new SFloat(8.5));
        NodeExternal l44 = new NodeExternal(new SInt(5));

        NodeAnd l31 = new NodeAnd(l41, l42);
        NodeExternal l32 = new NodeExternal(new SBinary("101"));
        NodeDivide l33 = new NodeDivide(l43, l44);
        NodeExternal l34 = new NodeExternal(new SInt(7));

        NodeSubtract l21 = new NodeSubtract(l31, l32);
        NodeMultiply l22 = new NodeMultiply(l33, l34);

        NodeAdd l11 = new NodeAdd(l21, l22);

        // AST instantiation and evaluation
        ast = new ASTree(l11);
        assertEquals(ast.evaluate(), new SFloat(14.9));
    }
}
