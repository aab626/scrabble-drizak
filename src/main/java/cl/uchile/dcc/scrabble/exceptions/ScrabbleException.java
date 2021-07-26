package cl.uchile.dcc.scrabble.exceptions;

/** Common exception superclass for all Scrabble Exceptions */
public class ScrabbleException extends Exception{
    public ScrabbleException(String msg){
        super(msg);
    }
}
