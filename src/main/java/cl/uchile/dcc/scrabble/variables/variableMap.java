package cl.uchile.dcc.scrabble.variables;

import cl.uchile.dcc.scrabble.exceptions.VariableNotFoundException;
import cl.uchile.dcc.scrabble.types.ISType;

import java.util.HashMap;

public class variableMap {
    private static variableMap singleton = null;
    private HashMap<String, ISType> varMap;

    private variableMap() {
        this.varMap = new HashMap<String, ISType>();
    }

    public static variableMap getInstance(){
        if (singleton == null){
            singleton = new variableMap();
        }

        return singleton;
    }

    public void setVar(String name, ISType variable){
        this.varMap.put(name, variable);
    }

    public ISType getVar(String name) throws VariableNotFoundException {
        if (this.varMap.containsKey(name)) {
            return this.varMap.get(name);
        } else {
            throw new VariableNotFoundException("Variable with name ".concat(name).concat(" was not found."));
        }

    }
}
