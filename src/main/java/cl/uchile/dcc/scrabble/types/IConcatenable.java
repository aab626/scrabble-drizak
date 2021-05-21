package cl.uchile.dcc.scrabble.types;

/**
 * Interface for concatenable Scrabble types
 */
public interface IConcatenable {
    /**
     * Method to concatenate a Scrabble Type with an SString
     * @param otherSString the SString calling the concatenation
     * @return SString, with the concatenation result
     */
    SString concatenateWithSString(SString otherSString);
}
