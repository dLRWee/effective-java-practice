package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

final class DeliveryOrder 
{
    private final String address;    
    private final List<Item> items;

    private DeliveryOrder(String address, List<Item> items)
    {
        Objects.requireNonNull(address);
        Objects.requireNonNull(items);

        this.address = address;
        this.items = items.stream()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    static DeliveryOrder newInstance(String address)
    {
        return new DeliveryOrder(address, Collections.emptyList());
    }

    static DeliveryOrder newInstance(String address, List<Item> items)
    {
        return new DeliveryOrder(address, items);
    }

    double weight()
    {
        return this.items.stream()
            .mapToDouble(Item::getWeight)
            .sum();
    }

    static class ShippingCalculator
    {
        static double calculate(double weight, double distance)
        {
            return weight * distance * 0.5;
        }
    }

    double calculateShippingCost(double distance)
    {
        return ShippingCalculator.calculate(weight(), distance);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        this.items.stream()
            .forEach(i -> stringBuilder.append(" " + i.toString() + "\n"));
        
        return String.format("Address: %s\nItems:\n%s", this.address, stringBuilder.toString());
    }
}