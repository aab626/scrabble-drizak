package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.utils.BinaryUtils;

import java.util.Objects;

/** Represents an Float (decimal) type for Scrabble, utilizing a Java double value */
public class SFloat implements IConcatenable, IArithmeticOperable {
    private double value;

    /**
     * SFloat Constructor
     * @param value double to represent
     */
    public SFloat(double value){
        this.value = value;
    }

    /**
     * Acts like a getValue()
     * @return value of internal double
     */
    public double toDouble(){
        return this.value;
    }

    /**
     * Setter for internal double
     * @param value New value of internal double
     */
    public void setDouble(double value) {
        this.value = value;
    }

    /**
     * @param obj Object to check for equality
     * @return true iff the other object is an SFloat, SInt or SBinary such as its internal value is the same
     * as of this SFloat internal double. false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SFloat){
            SFloat o = (SFloat) obj;
            return this.toDouble() == o.toDouble();
        }
        else if (obj instanceof SInt) {
            SInt o = (SInt) obj;
            return this.toDouble() == (double) o.toInt();
        }
        else if (obj instanceof SBinary) {
            SBinary o = (SBinary) obj;
            return this.toDouble() == (double) o.asSInt().toInt();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(SFloat.class);
    }

    /** @return String representation of the internal double*/
    @Override
    public String toString(){
        return String.valueOf(this.toDouble());
    }

    /** @return a copy of this SFloat */
    public SFloat copy() {
        return new SFloat(this.toDouble());
    }

    /** @return SString containing the internal double (as a String) */
    public SString asSString(){
        return new SString(this.toString());
    }

    @Override
    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }

    @Override
    public IArithmeticOperable add(IArithmeticOperable other) {
        return other.addSFloat(this);
    }

    @Override
    public SFloat addSInt(SInt other) {
        return new SFloat(this.toDouble() + other.toInt());
    }

    @Override
    public SFloat addSFloat(SFloat other) {
        return new SFloat(this.toDouble() + other.toDouble());
    }

    /**
     * Extra implementation: Operates with a SFloat, and returns a SFloat.
     * {@inheritDoc}
     */
    @Override
    public SFloat addSBinary(SBinary other) {
        return new SFloat(this.toDouble() + other.asSInt().toInt());
    }

    @Override
    public IArithmeticOperable subtract(IArithmeticOperable other) {
        return other.subtractSFloat(this);
    }

    @Override
    public SFloat subtractSInt(SInt other) {
        return new SFloat(-this.toDouble() + other.toInt());
    }

    @Override
    public SFloat subtractSFloat(SFloat other) {
        return new SFloat(-this.toDouble() + other.toDouble());
    }

    /**
     * Extra implementation: Operates with a SFloat, and returns a SFloat.
     * {@inheritDoc}
     */
    @Override
    public SFloat subtractSBinary(SBinary other) {
        return new SFloat(-this.toDouble() + other.asSInt().toInt());
    }

    @Override
    public IArithmeticOperable multiply(IArithmeticOperable other) {
        return other.multiplySFloat(this);
    }

    @Override
    public SFloat multiplySInt(SInt other) {
        return new SFloat(this.toDouble() * other.toInt());
    }

    @Override
    public SFloat multiplySFloat(SFloat other) {
        return new SFloat(this.toDouble() * other.toDouble());
    }

    /**
     * Extra implementation: Operates with a SFloat, and returns a SFloat.
     * {@inheritDoc}
     */
    @Override
    public SFloat multiplySBinary(SBinary other) {
        return new SFloat(this.toDouble() * other.asSInt().toInt());
    }

    @Override
    public IArithmeticOperable divide(IArithmeticOperable other) {
        return other.divideSFloat(this);
    }

    @Override
    public SFloat divideSInt(SInt other) {
        return new SFloat(other.toInt() / this.toDouble());
    }

    @Override
    public SFloat divideSFloat(SFloat other) {
        return new SFloat(other.toDouble() / this.toDouble());
    }

    /**
     * Extra implementation: Operates with a SFloat, and returns a SFloat.
     * {@inheritDoc}
     */
    @Override
    public SFloat divideSBinary(SBinary other) {
        return new SFloat(other.asSInt().toInt() / this.toDouble());
    }
}
