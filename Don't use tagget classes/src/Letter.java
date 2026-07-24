public final class Letter extends DeliveryItem
{
    private final int hashCode;
    
    private final int pageCount;

    private Letter(double weight, int pageCount)
    {
        super(weight);
        
        if (pageCount < 0)
            throw new IllegalArgumentException("Page count: " + pageCount);

        this.pageCount = pageCount;

        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.pageCount);
        this.hashCode = result;
    }

    public static Letter newInstance(double weight, int pageCount)
    {
        return new Letter(weight, pageCount);
    }

    public int getPageCount() { return this.pageCount; }

    @Override
    public double cost()
    {
        return this.weight * 10 + pageCount * 2;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof Letter))
            return false;

        Letter l = (Letter) object;

        return Double.compare(this.weight, l.weight) == 0 &&
               this.pageCount == l.pageCount;
    }

    @Override
    public int hashCode()
    {
        return this.hashCode;
    }

    /**
     * Returns a string representation of a {@code Letter} object.
     * 
     * <p>
     * The format is:
     * <ul>
     *  <li> Weight: weight
     *  <li> Page count: page count
     * </ul>
     * 
     * <p>
     * @return
     * A string representation of the object in specific format.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nPage count:\t%d", this.pageCount);
    }
}