package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

public class NodeNot extends NodeInternal implements IEvaluable{
    public NodeNot(IEvaluable node) {
        super(node);
    }

    @Override
    public ISType evaluate() {
        ILogicOperable result = (ILogicOperable) this.getOperand().evaluate();
        return (ISType) result.not();
    }
}
