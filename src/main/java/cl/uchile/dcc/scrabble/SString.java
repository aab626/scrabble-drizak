package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Represents an internal String type for Scrabble */
public class SString {
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
}
