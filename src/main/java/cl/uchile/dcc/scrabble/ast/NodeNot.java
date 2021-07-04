package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Logic NOT operation inside an AST. */
public class NodeNot extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Logic NOT Node
     * @param node Unique NOT operand
     */
    public NodeNot(IEvaluable node) {
        super(node);
    }

    @Override
    public ISType evaluate() {
        ILogicOperable result = (ILogicOperable) this.getOperand().evaluate();
        return (ISType) result.not();
    }
}
