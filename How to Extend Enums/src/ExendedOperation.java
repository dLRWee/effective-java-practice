public enum ExendedOperation implements Operation 
{
    EXP("^")
    {
        public double apply(double x, double y) { return Math.pow(x, y); }
    },
    REMAINDER("%")
    {
        public double apply(double x, double y) { return x % y; }
    };
    
    ExendedOperation(String symbol)
    {
        this.symbol = symbol;
    }
    
    private final String symbol;

    @Override
    public String toString()
    {
        return symbol;
    }
}