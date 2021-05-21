package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/** Represents an integer (int) type for Scrabble */
public class SInt extends SBaseType implements IArithmeticable{
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

    // todo implementar transformacion: sint -> sbin
//    public SBinary asSBinary() {
//    }

    public IArithmeticable add(IArithmeticable other) {
        return other.addSInt(this);
    }

    public IArithmeticable addSInt(SInt other) {
        return new SInt(this.toInt() + other.toInt());
    }

    public IArithmeticable addSFloat(SFloat other) {
        return new SFloat(this.toInt() + other.toDouble());
    }

    public IArithmeticable substract(IArithmeticable other) {
        return other.substractSInt(this);
    }

    public IArithmeticable substractSInt(SInt other) {
        return new SInt(-this.toInt() + other.toInt());
    }

    public IArithmeticable substractSFloat(SFloat other) {
        return new SFloat(-this.toInt() + other.toDouble());
    }

    public IArithmeticable multiply(IArithmeticable other) {
        return other.multiplySInt(this);
    }

    public IArithmeticable multiplySInt(SInt other) {
        return new SInt(this.toInt() * other.toInt());
    }

    public IArithmeticable multiplySFloat(SFloat other) {
        return new SFloat(this.toInt() * other.toDouble());
    }

    public IArithmeticable divide(IArithmeticable other) {
        return other.divideSInt(this);
    }

    public IArithmeticable divideSInt(SInt other) {
        return new SInt(other.toInt() / this.toInt());
    }

    public IArithmeticable divideSFloat(SFloat other) {
        return new SFloat(other.toDouble() / this.toInt());
    }



}