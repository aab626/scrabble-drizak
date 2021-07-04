package cl.uchile.dcc.scrabble.ast;

/** Holds common functionalities for all internal (operation) nodes inside an AST. */
public abstract class NodeInternal {
    // Holds the children of the current node.
    private IEvaluable[] children = new IEvaluable[2];

    /**
     * Constructor for nodes that use a binary operation
     * @param operandL First operand for the binary operation
     * @param operandR Second operand
     */
    public NodeInternal(IEvaluable operandL, IEvaluable operandR) {
        this.children[0] = operandL;
        this.children[1] = operandR;
    }

    /**
     * Constructor for nodes that use an unary operation
     * @param operand Unique operand for the operation
     */
    public NodeInternal(IEvaluable operand) {
        this.children[0] = operand;
    }

    /**
     * @return First operand for a binary operation
     */
    public IEvaluable getOperandL() {
        return this.children[0];
    }

    /**
     * @return Second operand for a binary operation
     */
    public IEvaluable getOperandR() {
        return this.children[1];
    }

    /**
     * @return Unique operand for an unary operation
     */
    public IEvaluable getOperand() {
        return this.getOperandL();
    }
}
