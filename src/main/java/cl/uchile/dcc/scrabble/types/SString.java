package cl.uchile.dcc.scrabble.types;

import java.util.Objects;

/** Represents an internal String type for Scrabble */
public class SString implements IConcatenable {
    private String value;

    /**
     * SString Constructor
     * @param value String to represent
     */
    public SString(String value){
        this.value = value;
    }

    /**
     * Acts like a getValue()
     * @return internal String
     */
    @Override
    public String toString(){
        return this.value;
    }

    /**
     * Setter for internal String
     * @param value New value for internal String
     */
    public void setString(String value) {
        this.value = value;
    }

    /**
     * @param obj Object to check for equality
     * @return true iff the other object is an SString containing the same internal String, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SString){
            SString s = (SString) obj;
            return this.toString().equals(s.toString());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(SString.class);
    }

    /** @return a copy of this SString */
    public SString copy() {
        return new SString(this.toString());
    }

    /**
     * Concatenates this SString with a Scrabble Type
     * @param other Another instance of a Scrabble Type
     * @return a new SString with the concatenated string of the original SString value
     * and the String representation of the other type
     */
    public SString concatenate(IConcatenable other) {
        return other.concatenateWithSString(this);
    }

    @Override
    public SString concatenateWithSString(SString other) {
        return new SString(other.toString() + this.toString());
    }
}
