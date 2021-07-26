package cl.uchile.dcc.scrabble.ast.flowcontrol;

import cl.uchile.dcc.scrabble.ast.ASTree;
import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ISType;
import cl.uchile.dcc.scrabble.utils.FlowControlUtils;

/** Internal node for the Scrabble equivalent of an If statement. */
public class NodeIf extends NodeInternal implements IEvaluable {
    private ASTree condition;
    private ASTree astTrue;
    private ASTree astFalse;

    /**
     * Constructor of the If Node
     * @param condition AST that holds the condition for the If statement, must evaluate to a SBool type.
     * @param astTrue AST that will be evaluated if the condition is true.
     * @param astFalse AST that will be evaluated if the condition is false.
     */
    public NodeIf(ASTree condition, ASTree astTrue, ASTree astFalse){
        super(condition, astTrue, astFalse);

        this.condition = condition;
        this.astTrue = astTrue;
        this.astFalse = astFalse;
    }

    @Override
    public ISType evaluate() throws ASTOperationException {
        boolean conditionResult = FlowControlUtils.evaluateCondition(this.condition);

        if (conditionResult) {
            return this.astTrue.evaluate();
        } else {
            return this.astFalse.evaluate();
        }
    }
}
