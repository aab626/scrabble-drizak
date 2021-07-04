package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ISType;

/** External (leaf) node inside an AST, holds a Scrabble Type as a value */
public class NodeExternal implements IEvaluable {
    private ISType value;

    /**
     * Constructor of the external node
     * @param value Value to hold
     */
    public NodeExternal(ISType value) {
        this.value = value;
    }

    @Override
    public ISType evaluate() {
        return this.value;
    }

    /**
     * Setter for the value of the node, used when creating nodes via NodeFactory
     * @param newValue the new value of the node
     */
    public void setValue(ISType newValue) {
        this.value = newValue;
    }
}
