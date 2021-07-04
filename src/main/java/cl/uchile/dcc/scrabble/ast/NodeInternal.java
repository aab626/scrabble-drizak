package cl.uchile.dcc.scrabble.ast;

public abstract class NodeInternal {
    private IEvaluable[] children = new IEvaluable[2];

    public NodeInternal(IEvaluable operandL, IEvaluable operandR) {
        this.children[0] = operandL;
        this.children[1] = operandR;
    }

    public NodeInternal(IEvaluable operand) {
        this.children[0] = operand;
    }

    public IEvaluable getOperandL() {
        return this.children[0];
    }

    public IEvaluable getOperandR() {
        return this.children[1];
    }

    public IEvaluable getOperand() {
        return this.getOperandL();
    }
}
