package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Order 
{
    private final List<Item> items;

    private Order(List<Item> items)
    {
        Objects.requireNonNull(items);

        this.items = items.stream()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    static Order newInstance(List<Item> items)
    {
        return new Order(items);
    }
    
    int totalAmount()
    {
        return this.items.stream()
            .mapToInt(Item::getPrice)
            .sum();
    }

    void addItem(Item item)
    {
        this.items.add(item);
    }

    static class Item
    {
        private final String name;
        private final int price;

        private Item(String name, int price)
        {
            Objects.requireNonNull(name);

            if (price < 0)
                throw new IllegalArgumentException("Price:\t" + price);

            this.name = name;
            this.price = price;
        }

        public static Item newInstance(String name, int price)
        {
            return new Item(name, price);
        }

        String getName() { return this.name; }
        int getPrice()  { return this.price; }

        @Override
        public String toString()
        {
            return String.format("%-10s (%d$)", this.name, this.price);
        }
    }

    class Discount
    {
        double calculate()
        {
            return totalAmount() * 0.1;
        }
    }

    @Override
    public String toString()
    {
        return this.items.stream()
            .map(Item::toString)
            .collect(Collectors.joining("\n"));
    }
}