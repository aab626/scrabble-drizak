package cl.uchile.dcc.scrabble.types;

/**
 * Interface for logic operations
 * NOT, AND and OR
 */
public interface ILogicOperable {
    /**
     * Method to be called to perform a NOT operation
     * @return the negation of the caller object
     */
    ILogicOperable not();

    /**
     * Method to be called to perform an AND operation
     * @param other Object to be operated with
     * @return Object result of the AND operation
     */
    ILogicOperable and(ILogicOperable other);

    /**
     * Logic AND operation, called by and when operated w/r to a SBool
     * @param other SBool to be operated with
     * @return Object result of the (SBool AND ILogicOperable) operation
     */
    ILogicOperable andSBool(SBool other);

    /**
     * Logic AND operation, called by and when operated w/r to a SBinary
     * @param other  SBinary to be operated with
     * @return SBinary result of the (SBinary AND ILogicOperable) operation
     */
    SBinary andSBinary(SBinary other);

    /**
     * Method to be called to perform an OR operation
     * @param other Object to be operated with
     * @return Object result of the AND operation
     */
    ILogicOperable or(ILogicOperable other);

    /**
     * Logic OR operation, called by and when operated w/r to a SBool
     * @param other SBool to be operated with
     * @return Object result of the (SBool OR ILogicOperable) operation
     */
    ILogicOperable orSBool(SBool other);

    /**
     * Logic OR operation, called by and when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return SBinary result of the (SBinary OR ILogicOperable) operation
     */
    SBinary orSBinary(SBinary other);
}
