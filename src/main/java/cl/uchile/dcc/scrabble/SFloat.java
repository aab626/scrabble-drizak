package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Represents an Float (decimal) type for Scrabble, utilizing a Java double value */
public class SFloat {
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
}
