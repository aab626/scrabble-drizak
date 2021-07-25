package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Logic AND operation inside an AST. */
public class NodeAnd extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the Logic AND Node
     * @param nodeL First AND operand
     * @param nodeR Second AND operand
     */
    public NodeAnd(IEvaluable nodeL, IEvaluable nodeR) {
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        try {
            ILogicOperable resultL = (ILogicOperable) this.getOperandL().evaluate();
            ILogicOperable resultR = (ILogicOperable) this.getOperandR().evaluate();
            return (ISType) resultL.and(resultR);
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to an IArithmeticOperable");
        }
    }
}
