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
    public IArithmeticOperable add(IArithmeticOperable other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt + IArithmeticOperable) operation
     */
    public IArithmeticOperable addSInt(SInt other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return Object result of the (SFloat + IArithmeticOperable) operation
     */
    public IArithmeticOperable addSFloat(SFloat other);

    /**
     * Arithmetic SUM operation, called by add when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return Object result of the (SBinary + IArithmeticOperable) operation
     */
    public IArithmeticOperable addSBinary(SBinary other);

    /**
     * Method to be called to perform a SUBTRACTION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable - other) operation
     */
    public IArithmeticOperable subtract(IArithmeticOperable other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt - IArithmeticOperable) operation
     */
    public IArithmeticOperable subtractSInt(SInt other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return Object result of the (SFloat - IArithmeticOperable) operation
     */
    public IArithmeticOperable subtractSFloat(SFloat other);

    /**
     * Arithmetic SUBTRACTION operation, called by subtract when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return Object result of the (SBinary - IArithmeticOperable) operation
     */
    public IArithmeticOperable subtractSBinary(SBinary other);

    /**
     * Method to be called to perform a MULTIPLICATION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable * other) operation
     */
    public IArithmeticOperable multiply(IArithmeticOperable other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (SInt * IArithmeticOperable) operation
     */
    public IArithmeticOperable multiplySInt(SInt other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return Object result of the (SFloat * IArithmeticOperable) operation
     */
    public IArithmeticOperable multiplySFloat(SFloat other);

    /**
     * Arithmetic MULTIPLICATION operation, called by multiply when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return Object result of the (SBinary * IArithmeticOperable) operation
     */
    public IArithmeticOperable multiplySBinary(SBinary other);

    /**
     * Method to be called to perform a DIVISION operation
     * @param other Object to be operated with
     * @return Object result of the (IArithmeticOperable / other) operation
     */
    public IArithmeticOperable divide(IArithmeticOperable other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SInt
     * @param other SInt to be operated with
     * @return Object result of the (IArithmeticOperable / SInt) operation
     */
    public IArithmeticOperable divideSInt(SInt other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SFloat
     * @param other SFloat to be operated with
     * @return Object result of the (IArithmeticOperable / SFloat) operation
     */
    public IArithmeticOperable divideSFloat(SFloat other);

    /**
     * Arithmetic DIVISION operation, called by divide when operated w/r to a SBinary
     * @param other SBinary to be operated with
     * @return Object result of the (IArithmeticOperable / SBinary) operation
     */
    public IArithmeticOperable divideSBinary(SBinary other);
}
