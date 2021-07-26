package cl.uchile.dcc.scrabble.ast.comparisons;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;

/** Internal node for a LEFT == RIGHT comparison inside an AST. */
public class NodeEqual extends NodeComparator implements IEvaluable {
    // L == R
    public NodeEqual(IEvaluable nodeL, IEvaluable nodeR){
        super(nodeL, nodeR);
    }

    @Override
    public SBool evaluate() throws ASTOperationException {
        int comparison = this.compare();
        if (comparison == 0){
            return returnTrue();
        } else {
            return returnFalse();
        }
    }
}
