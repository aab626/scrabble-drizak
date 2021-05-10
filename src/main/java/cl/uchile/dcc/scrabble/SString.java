package cl.uchile.dcc.scrabble;

import java.util.Objects;

/** Representa un tipo interno de String para Scrabble */
public class SString {
    private String value;

    /**
     * Constructor de SString
     * @param value String a representar
     */
    public SString(String value){
        this.value = value;
    }

    /**
     * Actúa como un getValue()
     * @return String representado
     */
    @Override
    public String toString(){
        return this.value;
    }

    /**
     * Setter del String interno
     * @param value Nuevo valor del String a representar
     */
    public void setString(String value) {
        this.value = value;
    }

    /**
     * @param obj Objeto a evaluar para la igualdad
     * @return true si y solo si el otro objeto es un SString que represente el mismo String. false en cualquier otro caso.
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
}
