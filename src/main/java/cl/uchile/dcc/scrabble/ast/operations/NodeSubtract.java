package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Subtraction operation inside an AST. */
public class NodeSubtract extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the Subtract Node
     * @param nodeL First subtraction operand
     * @param nodeR Second subtraction operand
     */
    public NodeSubtract(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        try {
            IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
            IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
            return (ISType) resultL.subtract(resultR);
        } catch (ClassCastException e) {
            throw new ASTOperationException();
        }
    }
}
