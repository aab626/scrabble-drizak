package cl.uchile.dcc.scrabble.ast.variables;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ISType;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.variables.variableMap;

/** Internal node to store a value into the variableMap, inside an AST. */
public class NodeSetVariable extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the variable setter node
     * @param nodeL A node such as when evaluated, it results in an SString containing the name of the variable.
     * @param nodeR A node that will be evaluated to a value, to store in the variable.
     */
    public NodeSetVariable(IEvaluable nodeL, IEvaluable nodeR){
        super(nodeL, nodeR);
    }

    @Override
    public ISType evaluate() throws ASTOperationException{
        SString varName;
        try {
            varName = (SString) this.getOperandL().evaluate();
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to a SString");
        }
        ISType variable = this.getOperandR().evaluate();

        variableMap.getInstance().setVar(varName.toString(), variable);
        return varName;
    }


}
