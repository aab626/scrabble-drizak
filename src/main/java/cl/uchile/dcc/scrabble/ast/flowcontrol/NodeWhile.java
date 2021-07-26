package cl.uchile.dcc.scrabble.ast.flowcontrol;

import cl.uchile.dcc.scrabble.ast.ASTree;
import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ISType;
import cl.uchile.dcc.scrabble.utils.FlowControlUtils;

/** Internal node for the Scrabble equivalent of a While statement. */
public class NodeWhile extends NodeInternal implements IEvaluable {
    ASTree condition;
    ASTree astTrue;
    ISType astResult;

    /**
     * Constructor of the While Node
     * @param condition AST that holds the condition for the If statement, must evaluate to a SBool type.
     * @param astTrue AST that will be evaluated while the condition is true.
     */
    public NodeWhile(ASTree condition, ASTree astTrue){
        super(condition, astTrue);
        this.condition = condition;
        this.astTrue = astTrue;
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        boolean conditionResult = FlowControlUtils.evaluateCondition(this.condition);

        // Evaluate AST, then evaluate the condition again.
        while (conditionResult){
            astResult = astTrue.evaluate();
            conditionResult = FlowControlUtils.evaluateCondition(this.condition);
        }

        return astResult;
    }
}
