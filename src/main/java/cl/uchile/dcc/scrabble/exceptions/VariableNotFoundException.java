package cl.uchile.dcc.scrabble.exceptions;

/** Thrown when there was an attempt to fetch a variable with an unused name inside a varMap object */
public class VariableNotFoundException extends ScrabbleException {
    public VariableNotFoundException(String msg){
        super(msg);
    }
}
