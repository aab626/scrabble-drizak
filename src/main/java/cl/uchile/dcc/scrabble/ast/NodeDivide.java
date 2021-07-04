package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Division operation inside an AST. */
public class NodeDivide extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Divide Node
     * @param nodeL First Division operand
     * @param nodeR Second Division operand
     */
    public NodeDivide(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() {
        IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
        IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
        return (ISType) resultL.divide(resultR);
    }
}
