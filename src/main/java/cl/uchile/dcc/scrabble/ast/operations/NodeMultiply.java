package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Multiply operation inside an AST. */
public class NodeMultiply extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the Multiply Node
     * @param nodeL First multiplication operand
     * @param nodeR Second multiplication operand
     */
    public NodeMultiply(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        try {
            IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
            IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
            return (ISType) resultL.multiply(resultR);
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to an IArithmeticOperable");
        }
    }
}
