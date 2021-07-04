package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Multiply operation inside an AST. */
public class NodeMultiply extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Multiply Node
     * @param nodeL First multiplication operand
     * @param nodeR Second multiplication operand
     */
    public NodeMultiply(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws UnsupportedOperandException {
        try {
            IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
            IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
            return (ISType) resultL.multiply(resultR);
        } catch (ClassCastException e) {
            throw new UnsupportedOperandException();
        }
    }
}
