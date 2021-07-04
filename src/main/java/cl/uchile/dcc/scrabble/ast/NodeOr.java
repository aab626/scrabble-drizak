package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

public class NodeOr extends NodeInternal implements IEvaluable{
    public NodeOr(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() {
        ILogicOperable resultL = (ILogicOperable) this.getOperandL().evaluate();
        ILogicOperable resultR = (ILogicOperable) this.getOperandR().evaluate();
        return (ISType) resultL.or(resultR);
    }
}
