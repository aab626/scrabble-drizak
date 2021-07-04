package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

public class NodeSubtract extends NodeInternal implements IEvaluable{
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
