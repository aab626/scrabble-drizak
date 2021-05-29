package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;

import java.util.Objects;

import static java.lang.Math.abs;

/** Represents an internal Binary type for Scrabble, using Strings composed of only 0s and 1s. */
public class SBinary implements IArithmeticOperable, IConcatenable, ILogicOperable {
    private String value;

    /**
     * SBinary Constructor
     * @param value Binary string (String composed of only 0s and 1s)
     */
    public SBinary (String value) {
        this.value = value;
    }

    /**
     * Acts like a getValue()
     * @return Value of internal binary string
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Setter for internal Binary string
     * @param value Binary string
     */
    public void setString(String value) {
        this.value = value;
    }

    /**
     * @param obj Object to check for equality
     * @return true iff the other object is an SBinary that represents the same binary number,
     * or a SFloat/SInt instance that holds the same number (in its decimal representation).
     * false otherwise
     */
    @Override
    public boolean equals(Object obj ){
        if (obj instanceof SBinary) {
            SBinary o = (SBinary) obj;
            return this.asSInt().toInt() == o.asSInt().toInt();
        } else if (obj instanceof SFloat) {
            SFloat o = (SFloat) obj;
            return (double) this.asSInt().toInt() == o.toDouble();
        } else if (obj instanceof SInt) {
            SInt o = (SInt) obj;
            return this.asSInt().toInt() == o.toInt();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(SBinary.class);
    }

    /** @return a copy of this SBinary */
    public SBinary copy() {
        return new SBinary(this.toString());
    }

    /** @return SString containing the Binary string (as the same String)*/
    public SString asSString() {
        return new SString(this.toString());
    }

    /** @return SFloat containing the decimal representation of the binary string */
    public SFloat asSFloat() {
        return new SFloat((double) BinaryUtils.toInt(this.toString()));
    }

    /** @return SInt containing the decimal representation of the binary string */
    public SInt asSInt() {
        return new SInt(BinaryUtils.toInt(this.toString()));
    }

    @Override
    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }

    @Override
    public IArithmeticOperable add(IArithmeticOperable other) {
        return other.addSBinary(this);
    }

    @Override
    public SInt addSInt(SInt other) {
        return new SInt(this.asSInt().toInt() + other.toInt());
    }

    @Override
    public SFloat addSFloat(SFloat other) {
        return new SFloat(this.asSInt().toInt() + other.toDouble());
    }

    @Override
    public SBinary addSBinary(SBinary other) {
        int integer1 = this.asSInt().toInt();
        int integer2 = other.asSInt().toInt();
        String binary = BinaryUtils.intToBinary(integer1 + integer2);
        return new SBinary(binary);
    }

    @Override
    public IArithmeticOperable subtract(IArithmeticOperable other) {
        return other.subtractSBinary(this);
    }

    @Override
    public SInt subtractSInt(SInt other) {
        return new SInt(-this.asSInt().toInt() + other.toInt());
    }

    @Override
    public SFloat subtractSFloat(SFloat other) {
        return new SFloat(-this.asSInt().toInt() + other.toDouble());
    }

    @Override
    public SBinary subtractSBinary(SBinary other) {
        int integer1 = this.asSInt().toInt();
        int integer2 = other.asSInt().toInt();
        String binary = BinaryUtils.intToBinary(-integer1 + integer2);
        return new SBinary(binary);
    }

    @Override
    public IArithmeticOperable multiply(IArithmeticOperable other) {
        return other.multiplySBinary(this);
    }

    @Override
    public SInt multiplySInt(SInt other) {
        return new SInt(this.asSInt().toInt() * other.toInt());
    }

    @Override
    public SFloat multiplySFloat(SFloat other) {
        return new SFloat(this.asSInt().toInt() * other.toDouble());
    }

    @Override
    public SBinary multiplySBinary(SBinary other) {
        int integer1 = this.asSInt().toInt();
        int integer2 = other.asSInt().toInt();
        String binary = BinaryUtils.intToBinary(integer1 * integer2);
        return new SBinary(binary);
    }

    @Override
    public IArithmeticOperable divide(IArithmeticOperable other) {
        return other.divideSBinary(this);
    }

    @Override
    public SInt divideSInt(SInt other) {
        return new SInt(other.toInt() / this.asSInt().toInt());
    }

    @Override
    public SFloat divideSFloat(SFloat other) {
        return new SFloat(other.toDouble() / this.asSInt().toInt());
    }

    @Override
    public SBinary divideSBinary(SBinary other) {
        int integer1 = this.asSInt().toInt();
        int integer2 = other.asSInt().toInt();
        String binary = BinaryUtils.intToBinary(integer2 / integer1);
        return new SBinary(binary);
    }

    @Override
    public SBinary not() {
        return new SBinary(BinaryUtils.invertBinary(this.toString()));
    }

    @Override
    public ILogicOperable and(ILogicOperable other) {
        return other.andSBinary(this);
    }

    @Override
    public SBinary andSBool(SBool other) {
        return new SBinary(BinaryUtils.andBinaryWithBool(this.toString(), other.toBool()));
    }

    @Override
    public SBinary andSBinary(SBinary other) {
        return new SBinary(BinaryUtils.andBinaries(this.toString(), other.toString()));
    }

    @Override
    public ILogicOperable or(ILogicOperable other) {
        return other.orSBinary(this);
    }

    @Override
    public SBinary orSBool(SBool other) {
        return new SBinary(BinaryUtils.orBinaryWithBool(this.toString(), other.toBool()));
    }

    @Override
    public SBinary orSBinary(SBinary other) {
        return new SBinary(BinaryUtils.orBinaries(this.toString(), other.toString()));
    }

}
