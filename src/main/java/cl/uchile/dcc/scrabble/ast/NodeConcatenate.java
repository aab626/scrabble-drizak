package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.UnsupportedOperandException;
import cl.uchile.dcc.scrabble.types.IArithmeticOperable;
import cl.uchile.dcc.scrabble.types.IConcatenable;
import cl.uchile.dcc.scrabble.types.ISType;
import cl.uchile.dcc.scrabble.types.SString;

/** Internal node for a Concatenation operation inside an AST. */
public class NodeConcatenate extends NodeInternal implements IEvaluable{
    /**
     * Constructor of the Add Node
     * @param nodeL First concatenation operand
     * @param nodeR Second concatenation operand
     */
    public NodeConcatenate(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws UnsupportedOperandException {
        try {
            IConcatenable resultL = (IConcatenable) this.getOperandL().evaluate();
            SString resultR = (SString) this.getOperandR().evaluate();
            return (ISType) resultL.concatenateWithSString(resultR);
        } catch (ClassCastException e) {
            throw new UnsupportedOperandException();
        }
    }
}