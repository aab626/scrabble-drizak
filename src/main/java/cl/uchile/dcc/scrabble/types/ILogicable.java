package cl.uchile.dcc.scrabble.types;

public interface ILogicable {
    public ILogicable not();

    public ILogicable and(ILogicable other);
    public ILogicable andSBool(SBool other);
    public ILogicable andSBinary(SBinary other);
//
    public ILogicable or(ILogicable other);
    public ILogicable orSBool(SBool other);
    public ILogicable orSBinary(SBinary other);
}
