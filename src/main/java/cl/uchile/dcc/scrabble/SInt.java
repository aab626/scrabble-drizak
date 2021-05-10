package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Representa un tipo interno de Int para Scrabble */
public class SInt {
    private int value;

    /**
     * Constructor de SInt
     * @param value int a representar
     */
    public SInt(int value) {
        this.value = value;
    }

    /** Actúa como un getValue()
     * @return valor del int interno */
    public int toInt() {
        return this.value;
    }

    /**
     * Setter del int interno
     * @param value Nuevo valor del int a representar
     */
    public void setInt(int value){
        this.value = value;
    }

    /**
     * @param obj Objeto a comparar la igualdad
     * @return true si el otro objeto es un SFloat o SInt tal que el numero (double o int) interno
     * sea igual al int interno en este SInt. false en cualquier otro caso.
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

    /** @return Representacion como string del double interno */
    @Override
    public String toString() {
        return String.valueOf(this.toInt());
    }

    /** @return SFloat que contiene el valor int interno como un double */
    public SFloat asSFloat() {
        return new SFloat((double) this.value);
    }

    /** @return SString que contiene el valor int interno como un string */
    public SString asSString() {
        return new SString(this.toString());
    }

    // todo implementar transformacion: sint -> sbin
//    public SBinary asSBinary() {
//    }

}
