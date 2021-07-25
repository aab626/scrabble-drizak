package cl.uchile.dcc.scrabble.ast.factory;

import cl.uchile.dcc.scrabble.ast.*;
import cl.uchile.dcc.scrabble.ast.comparisons.*;
import cl.uchile.dcc.scrabble.ast.flowcontrol.NodeIf;
import cl.uchile.dcc.scrabble.ast.flowcontrol.NodeWhile;
import cl.uchile.dcc.scrabble.ast.operations.*;

/** Factory used to ease node creation, all nodes created with this have null children,
 * these must be manually set using setOperandL, setOperandR, setOperand (in internal nodes)
 * or use setValue for external nodes.
 */
public class NodeFactory {
    /** NodeFactory constructor */
    public NodeFactory(){}

    /** @return A newly created NodeAdd internal node. */
    public NodeAdd createAdd(){
        return new NodeAdd(null, null);
    }

    /** @return A newly created NodeSubtract internal node. */
    public NodeSubtract createSubtract(){
        return new NodeSubtract(null, null);
    }

    /** @return A newly created NodeMultiply internal node. */
    public NodeMultiply createMultiply(){
        return new NodeMultiply(null, null);
    }

    /** @return A newly created NodeDivide internal node. */
    public NodeDivide createDivide(){
        return new NodeDivide(null, null);
    }

    /** @return A newly created NodeAnd internal node. */
    public NodeAnd createAnd(){
        return new NodeAnd(null, null);
    }

    /** @return A newly created NodeOr internal node. */
    public NodeOr createOr(){
        return new NodeOr(null, null);
    }

    /** @return A newly created NodeNot internal node. */
    public NodeNot createNot(){
        return new NodeNot(null);
    }

    /** @return A newly created NodeConcatenate internal node. */
    public NodeConcatenate createConcatenate(){
        return new NodeConcatenate(null, null);
    }

    /** @return A newly created NodeExternal (leaf node). */
    public NodeExternal createExternal(){
        return new NodeExternal(null);
    }

    /** @return A newly created NodeEqual internal node. */
    public NodeEqual createEqual() {return new NodeEqual(null, null);}

    /** @return A newly created NodeGreater internal node. */
    public NodeGreater createGreater() {return new NodeGreater(null, null);}

    /** @return A newly created NodeGreaterOrEqual internal node. */
    public NodeGreaterOrEqual createGreaterOrEqual() {return new NodeGreaterOrEqual(null, null);}

    /** @return A newly created NodeLess internal node. */
    public NodeLess createLess() {return new NodeLess(null, null);}

    /** @return A newly created NodeLessOrEqual internal node. */
    public NodeLessOrEqual createLessOrEqual() {return new NodeLessOrEqual(null, null);}

    /** @return A newly created NodeNotEqual internal node. */
    public NodeNotEqual createNotEqual() {return new NodeNotEqual(null, null);}

    /** @return A newly created NodeWhile internal node. */
    public NodeIf createIf() {return new NodeIf(null, null, null);}

    /** @return A newly created NodeNotEqual internal node. */
    public NodeWhile createWhile() {return new NodeWhile(null, null);}
}
