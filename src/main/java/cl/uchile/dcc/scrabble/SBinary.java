package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Representa un tipo interno Binario para Scrabble, utilizando String que contienen solo 0s y 1s. */
public class SBinary {
    private String value;

    /**
     * Constructor de SBinary
     * @param value String binaria (String compuesta de solo 0s y 1s)
     */
    public SBinary (String value) {
        this.value = value;
    }

    /** Actúa como un getValue()
     * @return Retorna el valor del string binario interno */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Setter del String binario interno
     * @param value String compuesto de 0s y 1s
     */
    public void setString(String value) {
        this.value = value;
    }

    /**
     * @param obj Objeto a comparar la igualdad
     * @return true si y solo si el otro objeto es un SBinary que represente el mismo numero binario,
     * false en cualquier otro caso
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

    /** @return SString que contiene el valor binario como un String */
    public SString asSString() {
        return new SString(this.toString());
    }

//    public SFloat asSFloat() {
//        // todo imeplementar transformacion sbin -> sfloat
//    }
//
//    public SInt asSInt() {
//        // todo implementar transformacion sbin -> sint
//    }

}
