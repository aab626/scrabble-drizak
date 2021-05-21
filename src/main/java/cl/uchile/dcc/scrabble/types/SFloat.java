package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/** Represents an Float (decimal) type for Scrabble, utilizing a Java double value */
public class SFloat extends SBaseType implements IArithmeticable{
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
     * @return true iff the other object is an SFloat or SInt such as its internal value is the same
     * as of this SFloat internal double. false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SFloat){
            SFloat o = (SFloat) obj;
            return this.toDouble() == o.toDouble();
        } else if (obj instanceof  SInt){
            SInt o = (SInt) obj;
            return this.toDouble() == (double) o.toInt();
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

    public IArithmeticable add(IArithmeticable other) {
        return other.addSFloat(this);
    }

    public IArithmeticable addSInt(SInt other) {
        return new SFloat(this.toDouble() + other.toInt());
    }

    public IArithmeticable addSFloat(SFloat other) {
        return new SFloat(this.toDouble() + other.toDouble());
    }

    public IArithmeticable substract(IArithmeticable other) {
        return other.substractSFloat(this);
    }

    public IArithmeticable substractSInt(SInt other) {
        return new SFloat(-this.toDouble() + other.toInt());
    }

    public IArithmeticable substractSFloat(SFloat other) {
        return new SFloat(-this.toDouble() + other.toDouble());
    }

    public IArithmeticable multiply(IArithmeticable other) {
        return other.multiplySFloat(this);
    }

    public IArithmeticable multiplySInt(SInt other) {
        return new SFloat(this.toDouble() * other.toInt());
    }

    public IArithmeticable multiplySFloat(SFloat other) {
        return new SFloat(this.toDouble() * other.toDouble());
    }

    public IArithmeticable divide(IArithmeticable other) {
        return other.divideSFloat(this);
    }

    public IArithmeticable divideSInt(SInt other) {
        return new SFloat(other.toInt() / this.toDouble());
    }

    public IArithmeticable divideSFloat(SFloat other) {
        return new SFloat(other.toDouble() / this.toDouble());
    }
}
