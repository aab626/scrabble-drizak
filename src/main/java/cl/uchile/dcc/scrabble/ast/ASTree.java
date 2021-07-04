package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ISType;

public class ASTree implements IEvaluable{
    private IEvaluable root;

    public ASTree(IEvaluable root) {
        this.root = root;
    }

    public ISType evaluate() {
        return root.evaluate();
    }
}
