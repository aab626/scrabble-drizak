package cl.uchile.dcc.scrabble.ast;

import cl.uchile.dcc.scrabble.types.ISType;

/**
 * Represents an Abstract Syntax Tree (AST) for Scrabble
 * Holds a root node, which points to other nodes inside a tree, with internal nodes for operations between their children nodes
 * and external (leaf) nodes holding the values to operate with.
 */
public class ASTree implements IEvaluable{
    private IEvaluable root;

    /**
     * Constructor of the AST
     * @param root Node at the root of the tree
     */
    public ASTree(IEvaluable root) {
        this.root = root;
    }

    @Override
    public ISType evaluate() {
        return root.evaluate();
    }
}
