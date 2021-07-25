package cl.uchile.dcc.scrabble.ast.variables;

import cl.uchile.dcc.scrabble.ast.IEvaluable;
import cl.uchile.dcc.scrabble.ast.NodeInternal;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.types.ISType;
import cl.uchile.dcc.scrabble.types.SString;
import cl.uchile.dcc.scrabble.variables.variableMap;

/** Internal node to retrieve a variable from the variableMap inside an AST. */
public class NodeGetVariable extends NodeInternal implements IEvaluable {
    /**
     * Constructor of the variable getter node
     * @param node A node such as when evaluated, it results in an SString containing the name of the variable.
     */
    public NodeGetVariable(IEvaluable node) {
        super(node);
    }

    @Override
    public ISType evaluate() throws ASTOperationException{
        try {
            SString varName = (SString) this.getOperand().evaluate();
            return variableMap.getInstance().getVar(varName.toString());
        } catch (VariableNotFoundException e) {
            throw new ASTOperationException();
        }
    }

}
