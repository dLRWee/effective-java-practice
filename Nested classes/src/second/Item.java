package second;

import java.util.Objects;

final class Item 
{
    private final String name;
    private final double weight;

    private Item(String name, double weight)
    {
        Objects.requireNonNull(name);

        if (weight < 0)
            throw new IllegalArgumentException("Weight:\t" + weight);

        this.name = name;
        this.weight = weight;
    }

    public static Item newInstance(String name, double weight)
    {
        return new Item(name, weight);
    }

    String getName()   { return this.name; }
    double getWeight() { return this.weight; }

    @Override
    public String toString()
    {
        return String.format("%-10s (%.2f kg)", this.name, this.weight);
    }
}