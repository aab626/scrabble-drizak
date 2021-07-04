package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Subtraction operation inside an AST. */
public class NodeSubtract extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Subtract Node
     * @param nodeL First subtraction operand
     * @param nodeR Second subtraction operand
     */
    public NodeSubtract(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() {
        IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
        IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
        return (ISType) resultL.subtract(resultR);
    }
}
