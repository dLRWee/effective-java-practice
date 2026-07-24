public abstract class DeliveryItem
{
    protected final double weight;

    protected DeliveryItem(double weight)
    {
        if (weight < 0)
            throw new IllegalArgumentException("Weight: " + weight);

        this.weight = weight;
    }
    
    public abstract double cost();
    
    public double getWeight() { return this.weight; }
    
    @Override
    public int hashCode()
    {
        return Double.hashCode(this.weight);
    }
    
    // Я не перекрыл equals, потому что невозможно в при добавлении значимого поля в наследуемые класс сохранить контракт
    
    /**
     * Returns a string representation of a {@code DeliveryItem} object.
     * 
     * <p>
     * The format is: {@code Weight: weight}
     * 
     * <p>
     * @return
     * A string representation of the object in specific format.
     */
    @Override
    public String toString()
    {
        return String.format("Weight:\t\t%.2f", this.weight); 
    }
}