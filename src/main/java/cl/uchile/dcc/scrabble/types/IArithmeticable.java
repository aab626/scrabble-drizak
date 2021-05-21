package cl.uchile.dcc.scrabble.types;

public interface IArithmeticable {
    public IArithmeticable add(IArithmeticable other);
    public IArithmeticable addSInt(SInt other);
    public IArithmeticable addSFloat(SFloat other);
    // todo implement ADD to Sbinary
//    public IArithmeticable addSBinary(SBinary other);

    public IArithmeticable substract(IArithmeticable other);
    public IArithmeticable substractSInt(SInt other);
    public IArithmeticable substractSFloat(SFloat other);
    // todo implement SUBSTRACT to Sbinary
    // public IArithmeticable substractSBinary(SBinary other);

    public IArithmeticable multiply(IArithmeticable other);
    public IArithmeticable multiplySInt(SInt other);
    public IArithmeticable multiplySFloat(SFloat other);
    // todo implement MULTIPLY To SBINARY
    // public IArithmeticable multiplySBinary(SBinary other);

    public IArithmeticable divide(IArithmeticable other);
    public IArithmeticable divideSInt(SInt other);
    public IArithmeticable divideSFloat(SFloat other);
    // todo implement DIVIDE to SBINARY
    // public IArithmeticable divideSBinary(SBinary other);
}
