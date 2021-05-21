package cl.uchile.dcc.scrabble.types;

/**
 * Interface for arithmetic operations
 * SUM, SUBTRACTION, MULTIPLICATION and DIVISION
 */
public interface IArithmeticOperable {
    /**
     * Method to be called to perform a SUM operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable + other) operation
     */
    IArithmeticOperable add(IArithmeticOperable other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt + IArithmeticOperable) operation
     */
    IArithmeticOperable addSInt(SInt other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return SFloat result of the (SFloat + IArithmeticOperable) operation
     */
    SFloat addSFloat(SFloat other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return Object result of the (SBinary + IArithmeticOperable) operation
     */
    IArithmeticOperable addSBinary(SBinary other);

    /**
     * Method to be called to perform a SUBTRACTION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable - other) operation
     */
    IArithmeticOperable subtract(IArithmeticOperable other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt - IArithmeticOperable) operation
     */
    IArithmeticOperable subtractSInt(SInt other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return SFloat result of the (SFloat - IArithmeticOperable) operation
     */
    SFloat subtractSFloat(SFloat other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return SBinary result of the (SBinary - IArithmeticOperable) operation
     */
    SBinary subtractSBinary(SBinary other);

    /**
     * Method to be called to perform a MULTIPLICATION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable * other) operation
     */
    IArithmeticOperable multiply(IArithmeticOperable other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt * IArithmeticOperable) operation
     */
    IArithmeticOperable multiplySInt(SInt other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return SFloat result of the (SFloat * IArithmeticOperable) operation
     */
    SFloat multiplySFloat(SFloat other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return SBinary result of the (SBinary * IArithmeticOperable) operation
     */
    SBinary multiplySBinary(SBinary other);

    /**
     * Method to be called to perform a DIVISION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable / other) operation
     */
    IArithmeticOperable divide(IArithmeticOperable other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (IArithmeticOperable / SInt) operation
     */
    IArithmeticOperable divideSInt(SInt other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return SFloat result of the (IArithmeticOperable / SFloat) operation
     */
    SFloat divideSFloat(SFloat other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return SBinary result of the (IArithmeticOperable / SBinary) operation
     */
    SBinary divideSBinary(SBinary other);
}
