package cl.uchile.dcc.scrabble.types.factory;

import cl.uchile.dcc.scrabble.types.*;

import java.util.HashMap;

/**
 * Flyweight Factory, Stores all created Scrabble Types into a hashmap to ease memory usage.
 * When creating new objects, the factory checks if there is already a created version of this element,
 * then returns it without instantiating a new one (it does in case it did not found a stored copy).
 */
public class FlyweightFactory {
    private HashMap<String, ISType> map;

    /** Constructor of the Flyweight Factory, initializes the hashmap */
    public FlyweightFactory(){
        this.map = new HashMap<>();
    }

    /**
     * Hashes an integer in a distinct format "int-VALUE"
     * @param n Integer to be hashed
     * @return The hash of the integer
     */
    private String hashInt(int n) {
        return "int-".concat(String.valueOf(n));
    }

    /**
     * Hashes a binary in a distinct format "bin-VALUE"
     * @param binaryString binary string to be hashed
     * @return The hash of the binary string
     */
    private String hashBinary(String binaryString) {
        return "bin-".concat(binaryString);
    }

    /**
     * Hashes a boolean in a distinct format "bool-VALUE"
     * @param bool Boolean to be hashed
     * @return The hash of the boolean
     */
    private String hashBool(boolean bool) {
        return "bool-".concat(String.valueOf(bool));
    }

    /**
     * Hashes a double in a distinct format "dbl-VALUE"
     * @param db Double to be hashed
     * @return The hash of the double
     */
    private String hashDouble(double db) {
        return "dbl-".concat(String.valueOf(db));
    }

    /**
     * Hashes a string in a distinct format "str-VALUE"
     * @param str String to be hashed
     * @return The hash of the string
     */
    private String hashString(String str) {
        return "str-".concat(str);
    }

    /**
     * Creates an SInt, searching first for a stored copy to return.
     * @param n Integer used to create the SInt
     * @return SInt instantiated or found.
     */
    public SInt createSInt (int n) {
        String hash = this.hashInt(n);
        if (map.containsKey(hash)) {
            return (SInt) map.get(hash);
        } else {
            SInt value = new SInt(n);
            map.put(hash, value);
            return value;
        }
    }

    /**
     * Creates an SBinary, searching first for a stored copy to return.
     * @param binaryString Binary String used to create the SBinary
     * @return SBinary instantiated or found.
     */
    public SBinary createSBinary (String binaryString) {
        String hash = this.hashBinary(binaryString);
        if (map.containsKey(hash)) {
            return (SBinary) map.get(hash);
        } else {
            SBinary value = new SBinary(binaryString);
            map.put(hash, value);
            return value;
        }
    }

    /**
     * Creates an SBool, searching first for a stored copy to return.
     * @param bool Boolean value used to create the SBool
     * @return SBinary instantiated or found.
     */
    public SBool createSBool (boolean bool) {
        String hash = this.hashBool(bool);
        if (map.containsKey(hash)) {
            return (SBool) map.get(hash);
        } else {
            SBool value = new SBool(bool);
            map.put(hash, value);
            return value;
        }
    }

    /**
     * Creates an SFloat, searching first for a stored copy to return.
     * @param doubleNumber Double value used to create the SFloat
     * @return SFloat instantiated or found.
     */
    public SFloat createSFloat (double doubleNumber) {
        String hash = this.hashDouble(doubleNumber);
        if (map.containsKey(hash)) {
            return (SFloat) map.get(hash);
        } else {
            SFloat value = new SFloat(doubleNumber);
            map.put(hash, value);
            return value;
        }
    }

    /**
     * Creates an SString, searching first for a stored copy to return.
     * @param str String value used to create the SString
     * @return SString instantiated or found.
     */
    public SString createSString (String str) {
        String hash = this.hashString(str);
        if (map.containsKey(hash)) {
            return (SString) map.get(hash);
        } else {
            SString value = new SString(str);
            map.put(hash, value);
            return value;
        }
    }


}
