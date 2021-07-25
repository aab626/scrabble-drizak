package cl.uchile.dcc.scrabble.ast.comparisons;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.SBool;

/** Base class for all comparator nodes */
public abstract class NodeComparator extends NodeInternal {
    /** Constructor for comparator nodes */
    public NodeComparator(IEvaluable nodeL, IEvaluable nodeR){
        super(nodeL, nodeR);
    }


    /**
     * Compares two nodes, using the Comparable interface
     * @return 1 if the left node is greater than the right node.
     *         0 if the left node is equal to the right node.
     *         -1 if the left node is less than the right node.
     * @throws ASTOperationException when a comparison is not possible.
     */
    protected int compare() throws ASTOperationException {
        try {
            Comparable<IArithmeticOperable> comparedL = (Comparable<IArithmeticOperable>) this.getOperandL().evaluate();
            IArithmeticOperable comparedR = (IArithmeticOperable) this.getOperandR().evaluate();
            return comparedL.compareTo(comparedR);
        } catch (ClassCastException e) {
            throw new ASTOperationException("Comparison between these types is not possible.");
        }
    }

    /**
     * Shorthand for creating new true values.
     * @return a true SBool.
     */
    protected final SBool returnTrue(){
        return new SBool(true);
    }

    /**
     * Shorthand for creating new false values.
     * @return a false SBool.
     */
    protected final SBool returnFalse(){
        return new SBool(false);
    }
}
