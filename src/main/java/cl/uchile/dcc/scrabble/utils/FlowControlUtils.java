package cl.uchile.dcc.scrabble.utils;


import cl.uchile.dcc.scrabble.ast.ASTree;
import cl.uchile.dcc.scrabble.exceptions.ASTOperationException;
import cl.uchile.dcc.scrabble.types.SBool;

public class FlowControlUtils {
    static public boolean evaluateCondition(ASTree condition) throws ASTOperationException {
        SBool result;

        try{
            result = (SBool) condition.evaluate();
        } catch (ClassCastException e) {
            throw new ASTOperationException("Evaluation result could not be casted to a SBool");
        }

        return result.toBool();
    }
}
