package cl.uchile.dcc.scrabble.ast.factory;

import cl.uchile.dcc.scrabble.ast.*;

/** Factory used to ease node creation, all nodes created with this have null children,
 * these must be manually set using setOperandL, setOperandR, setOperand (in internal nodes)
 * or use setValue for external nodes.
 */
public class NodeFactory {
    /** NodeFactory constructor */
    public NodeFactory(){

    }


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
}
