package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;

import java.util.Objects;

import static java.lang.Math.abs;

/** Represents an internal Binary type for Scrabble, using Strings composed of only 0s and 1s. */
public class SBinary implements IConcatenable, ILogicable {
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
     * false otherwise
     */
    // todo revisar si esta comparacion es correcta siempre, "0010" == "10"?
    @Override
    public boolean equals(Object obj ){
        if (obj instanceof SBinary) {
            SBinary o = (SBinary) obj;
            return this.toString().equals(o.toString());
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

    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }

    public SBinary not() {
        return new SBinary(BinaryUtils.invertBinary(this.toString()));
    }

    public ILogicable and(ILogicable other) {
        return other.andSBinary(this);
    }

    public SBinary andSBool(SBool other) {
        return new SBinary(BinaryUtils.andBinaryWithBool(this.toString(), other.toBool()));
    }

    public SBinary andSBinary(SBinary other) {
        return new SBinary(BinaryUtils.andBinaries(this.toString(), other.toString()));
    }

    public ILogicable or(ILogicable other) {
        return other.orSBinary(this);
    }

    public SBinary orSBool(SBool other) {
        return new SBinary(BinaryUtils.orBinaryWithBool(this.toString(), other.toBool()));
    }

    public SBinary orSBinary(SBinary other) {
        return new SBinary(BinaryUtils.orBinaries(this.toString(), other.toString()));
    }

}
