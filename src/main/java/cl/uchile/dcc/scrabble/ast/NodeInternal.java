package cl.uchile.dcc.scrabble.ast;

import java.util.ArrayList;

/** Holds common functionalities for all internal (operation) nodes inside an AST. */
public abstract class NodeInternal {
    // Holds the children of the current node.
    private ArrayList<IEvaluable> children;

    /** Constructor for internal nodes, may take several children */
    public NodeInternal(IEvaluable... operands) {
        this.children = new ArrayList<IEvaluable>();

        for (IEvaluable operand:operands) {
            this.children.add(operand);
        }
    }

// OLD CONSTRUCTORS
//    /**
//     * Constructor for nodes that use a binary operation
//     * @param operandL First operand for the binary operation
//     * @param operandR Second operand
//     */
//    public NodeInternal(IEvaluable operandL, IEvaluable operandR) {
//        this.children = new ArrayList<IEvaluable>();
//        this.children.add(operandL);
//        this.children.add(operandR);
//    }
//
//    /**
//     * Constructor for nodes that use a binary operation
//     * @param operandL First operand for the binary operation
//     * @param operandR Second operand
//     */
//    public NodeInternal(IEvaluable operandL, IEvaluable operandR) {
//        this.children = new ArrayList<IEvaluable>();
//        this.children.add(operandL);
//        this.children.add(operandR);
//    }
//
//    /**
//     * Constructor for nodes that use an unary operation
//     * @param operand Unique operand for the operation
//     */
//    public NodeInternal(IEvaluable operand) {
//        this.children = new ArrayList<IEvaluable>();
//        this.children.add(operand);
//    }

    /**
     * @return First operand for a binary operation
     */
    public IEvaluable getOperandL() {
        return this.children.get(0);
    }

    /**
     * @return Second operand for a binary operation
     */
    public IEvaluable getOperandR() {
        return this.children.get(1);
    }

    /**
     * @return Unique operand for an unary operation
     */
    public IEvaluable getOperand() {
        return this.getOperandL();
    }

    /**
     * Setter for the first operand in binary operations
     * @param operand to be set
     */
    public void setOperandL(IEvaluable operand) {
        this.children.set(0, operand);
    }

    /**
     * Setter for the second operand in binary operations
     * @param operand to be set
     */
    public void setOperandR(IEvaluable operand) {
        this.children.set(1, operand);
    }

    /**
     * Setter for the unique operand in unary operations
     * @param operand to be set
     */
    public void setOperand(IEvaluable operand) {
        this.setOperandL(operand);
    }
}
