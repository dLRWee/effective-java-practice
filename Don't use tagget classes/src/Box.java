public final class Box extends DeliveryItem 
{
    private final int hashCode;
    
    private final double width;
    private final double height;
    private final double depth;

    private Box(double weight, double width, double height, double depth)
    {
        super(weight);

        if (width < 0)
            throw new IllegalArgumentException("Width: " + width);

        if (height < 0)
            throw new IllegalArgumentException("Height: " + height);

        if (depth < 0)
            throw new IllegalArgumentException("Depth: " + depth);

        this.width = width;
        this.height = height;
        this.depth = depth;

        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.width);
        result = 31 * result + Double.hashCode(this.height);
        result = 31 * result + Double.hashCode(this.depth);
        this.hashCode = result;
    }

    public static Box newInstance(double weight, double width, double height, double depth)
    {
        return new Box(weight, width, height, depth);
    }

    public double getWidth()  { return this.width; }
    public double getHeight() { return this.height; }
    public double getDepth()  { return this.depth; }

    @Override
    public double cost()
    {
        return (this.width * this.height * this.depth) * 0.05 + this.weight * 15;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof Box))
            return false;

        Box b = (Box) object;

        return Double.compare(this.weight, b.weight) == 0 &&
               Double.compare(this.width, b.width) == 0 &&
               Double.compare(this.height, b.height) == 0 &&
               Double.compare(this.depth, b.depth) == 0;
    }

    @Override
    public int hashCode()
    {
        return this.hashCode;
    }

    /**
     * Returns a string representation of a {@code Box} object.
     * 
     * <p>
     * The format is:
     * <ul>
     *  <li> Weight: weight
     *  <li> Width: width
     *  <li> Height: height
     *  <li> Depth: depth
     * </ul>
     * 
     * <p>
     * @return
     * A string representation of the object in specific format.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(
            "\nWidth:\t\t%.2f\nHeight:\t\t%.2f\nDepth:\t\t%.2f", this.width, this.height, this.depth);
    }
}