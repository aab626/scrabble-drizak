package cl.uchile.dcc.scrabble.ast.comparisons;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;

/** Internal node for a LEFT >= RIGHT comparison inside an AST. */
public class NodeGreaterOrEqual extends NodeComparator implements IEvaluable {
    // L >= R
    public NodeGreaterOrEqual(IEvaluable nodeL, IEvaluable nodeR){
        super(nodeL, nodeR);
    }

    @Override
    public SBool evaluate() throws ASTOperationException {
        int comparison = this.compare();
        if (comparison == 1 || comparison == 0){
            return returnTrue();
        } else {
            return returnFalse();
        }
    }
}
