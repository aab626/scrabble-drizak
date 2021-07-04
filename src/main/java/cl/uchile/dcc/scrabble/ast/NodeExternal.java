package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ISType;

public class NodeExternal implements IEvaluable {
    ISType value;

    public NodeExternal(ISType value) {
        this.value = value;
    }

    @Override
    public ISType evaluate() {
        return this.value;
    }
}
