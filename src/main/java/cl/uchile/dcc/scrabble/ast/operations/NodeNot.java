package cl.uchile.dcc.scrabble.ast.operations;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ILogicOperable;
import cl.uchile.dcc.scrabble.types.ISType;

/** Internal node for a Logic NOT operation inside an AST. */
public class NodeNot extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the Logic NOT Node
     * @param node Unique NOT operand
     */
    public NodeNot(IEvaluable node) {
        super(node);
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        try {
            ILogicOperable result = (ILogicOperable) this.getOperand().evaluate();
            return (ISType) result.not();
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to an IArithmeticOperable");
        }
    }
}
