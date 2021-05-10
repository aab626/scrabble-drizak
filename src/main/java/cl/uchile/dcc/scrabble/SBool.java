package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Representa un tipo interno de Booleano para Scrabble */
public class SBool {
    private boolean value;

    /**
     * Constructor de SBool
     * @param value Booleano a representar
     */
    public SBool(boolean value){
        this.value = value;
    }

    /** Actúa como un getValue()
     * @return valor del booleano interno */
    public boolean toBool(){
        return this.value;
    }

    /**
     * Setter del Booleano interno
     * @param value Nuevo valor del boolean a representar
     */
    public void setBool(boolean value){
        this.value = value;
    }

    /**
     * @param obj Objeto a evaluar para la igualdad
     * @return Retorna true si y solo si el otro objeto es un SBool que represente el mismo boolean. Retorna false en cualquier otro caso
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SBool){
            SBool o = (SBool) obj;
            return this.toBool() == o.toBool();
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(SBool.class);
    }

    /**
     * Retorna la representacion como String del booleano interno
     * @return "true" o "false"
     */
    @Override
    public String toString(){
        return String.valueOf(this.toBool());
    }

    /**
     * @return SString que contiene el valor booleano interno como un string
     */
    public SString asSString(){
        return new SString(this.toString());
    }
}
