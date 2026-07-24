public enum BasicOperation implements Operation
{
    PLUS("+")
    {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-")
    {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*")
    {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/")
    {
        public double apply(double x, double y) { return x / y; }
    };
    
    BasicOperation(String symbol)
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