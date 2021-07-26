package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.ISType;

/**
 * Common interface for all classes part of the AST composite.
 */
public interface IEvaluable {
    /**
     * Evaluates the node, via recursively computing its operation or returning its value.
     * @return the final value of this AST piece (A tree or a node).
     * @throws ASTOperationException when one of the operands does not comply with the contract
     *                                     of the specified operation interface
     */
    ISType evaluate() throws ASTOperationException;
}
