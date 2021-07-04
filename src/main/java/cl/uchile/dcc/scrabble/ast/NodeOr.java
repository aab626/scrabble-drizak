package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Logic OR operation inside an AST. */
public class NodeOr extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Logic OR Node
     * @param nodeL First OR operand
     * @param nodeR Second OR operand
     */
    public NodeOr(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws UnsupportedOperandException {
        try {
            ILogicOperable resultL = (ILogicOperable) this.getOperandL().evaluate();
            ILogicOperable resultR = (ILogicOperable) this.getOperandR().evaluate();
            return (ISType) resultL.or(resultR);
        }  catch (ClassCastException e) {
            throw new UnsupportedOperandException();
        }
    }
}
