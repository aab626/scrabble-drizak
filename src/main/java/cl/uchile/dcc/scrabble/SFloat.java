package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Representa un tipo interno de Float utilizando double para Scrabble */
public class SFloat {
    private double value;

    /**
     * Constructor de SFloat
     * @param value double a representar
     */
    public SFloat(double value){
        this.value = value;
    }

    /** Actúa como un getValue()
     * @return valor del double interno */
    public double toDouble(){
        return this.value;
    }

    /**
     * Setter del double interno
     * @param value Nuevo valor del double a representar
     */
    public void setDouble(double value) {
        this.value = value;
    }

    /**
     * @param obj Objeto a evaluar para la igualdad
     * @return true si el otro objeto es un SFloat o SInt tal que el numero (double o int)
     * interno sea igual al double interno en este SFloat. false en cualquier otro caso.
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

    /** @return Representacion como string del double interno */
    @Override
    public String toString(){
        return String.valueOf(this.toDouble());
    }

    /** @return SString que contiene el valor double interno como un string */
    public SString asSString(){
        return new SString(this.toString());
    }
}
