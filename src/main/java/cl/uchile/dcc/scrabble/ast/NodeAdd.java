package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for an Addition operation inside an AST. */
public class NodeAdd extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Add Node
     * @param nodeL First addition operand
     * @param nodeR Second addition operand
     */
    public NodeAdd(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws UnsupportedOperandException{
        try {
            IArithmeticOperable resultL = (IArithmeticOperable) this.getOperandL().evaluate();
            IArithmeticOperable resultR = (IArithmeticOperable) this.getOperandR().evaluate();
            return (ISType) resultL.add(resultR);
        } catch (ClassCastException e) {
            throw new UnsupportedOperandException();
        }
    }
}

