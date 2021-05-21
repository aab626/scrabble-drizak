package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;

import java.util.Objects;

/** Represents an integer (int) type for Scrabble */
public class SInt extends SBaseType implements IConcatenable, IArithmeticable{
    private int value;

    /**
     * SInt constructor
     * @param value int to represent
     */
    public SInt(int value) {
        this.value = value;
    }

    /**
     * Acts like a getValue()
     * @return value of internal int
     */
    public int toInt() {
        return this.value;
    }

    /**
     * Setter of internal int
     * @param value New internal int value
     */
    public void setInt(int value){
        this.value = value;
    }

    /**
     * @param obj Object to check for equality
     * @return true iff the other object is an SFloat or SInt such as its internal value is the same
     * as of this SInt internal value. false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SInt){
            SInt o = (SInt) obj;
            return this.toInt() == o.toInt();
        }
        else if (obj instanceof SFloat) {
            SFloat o = (SFloat) obj;
            return ((double) this.toInt() == o.toDouble());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(SInt.class);
    }

    /** @return String representation of internal int */
    @Override
    public String toString() {
        return String.valueOf(this.toInt());
    }

    /** @return a copy of this SInt */
    public SInt copy() {
        return new SInt(this.toInt());
    }

    /** @return SFloat containing the internal int value (as a double) */
    public SFloat asSFloat() {
        return new SFloat((double) this.value);
    }

    /** @return SString containing the internal int value (as a string) */
    public SString asSString() {
        return new SString(this.toString());
    }

    /** @return SBinary containing the internal int value (as a binary string) */
    public SBinary asSBinary() {
        return new SBinary(BinaryUtils.intToBinary(this.toInt()));
    }

    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }

    public IArithmeticable add(IArithmeticable other) {
        return other.addSInt(this);
    }

    public SInt addSInt(SInt other) {
        return new SInt(this.toInt() + other.toInt());
    }

    public SFloat addSFloat(SFloat other) {
        return new SFloat(this.toInt() + other.toDouble());
    }

    public SBinary addSBinary(SBinary other) {
        return new SBinary(BinaryUtils.intToBinary(this.toInt() + other.asSInt().toInt()));
    }

    public IArithmeticable substract(IArithmeticable other) {
        return other.substractSInt(this);
    }

    public SInt substractSInt(SInt other) {
        return new SInt(-this.toInt() + other.toInt());
    }

    public SFloat substractSFloat(SFloat other) {
        return new SFloat(-this.toInt() + other.toDouble());
    }

    public SBinary substractSBinary(SBinary other) {
        return new SBinary(BinaryUtils.intToBinary(-this.toInt() + other.asSInt().toInt()));
    }

    public IArithmeticable multiply(IArithmeticable other) {
        return other.multiplySInt(this);
    }

    public SInt multiplySInt(SInt other) {
        return new SInt(this.toInt() * other.toInt());
    }

    public SFloat multiplySFloat(SFloat other) {
        return new SFloat(this.toInt() * other.toDouble());
    }

    public SBinary multiplySBinary(SBinary other) {
        return new SBinary(BinaryUtils.intToBinary(this.toInt() * other.asSInt().toInt()));
    }

    public IArithmeticable divide(IArithmeticable other) {
        return other.divideSInt(this);
    }

    public SInt divideSInt(SInt other) {
        return new SInt(other.toInt() / this.toInt());
    }

    public SFloat divideSFloat(SFloat other) {
        return new SFloat(other.toDouble() / this.toInt());
    }

    public SBinary divideSBinary(SBinary other) {
        return new SBinary(BinaryUtils.intToBinary(other.asSInt().toInt() / this.toInt()));
    }



}
