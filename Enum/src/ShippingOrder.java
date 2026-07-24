import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ShippingOrder 
{
    STANDART(1.1, ShippingStrategy.DOMESTIC),
    EXPRESS(1.5, ShippingStrategy.DOMESTIC),
    INTERNATIONAL(1.8, ShippingStrategy.SPECIAL),
    FRAGILE(1.9, ShippingStrategy.SPECIAL);
    
    private static final Map<String, ShippingOrder> STRING_TO_ENUM = 
        Stream.of(values())
            .collect(Collectors.toMap(Object::toString, e -> e));
    
    private final double baseRate;
    private final ShippingStrategy strategy;

    ShippingOrder(double baseRate, ShippingStrategy strategy)
    {
        this.baseRate = baseRate;
        this.strategy = strategy;
    }

    private enum ShippingStrategy
    {
        DOMESTIC
        {
            @Override
            double calculate(double weight, double baseRate)
            {
                return weight * baseRate * 1.5;
            }
        },
        SPECIAL
        {
            @Override
            double calculate(double weight, double baseRate)
            {
                return weight * baseRate * 2.4;
            }
        };

        abstract double calculate(double weight, double baseRate);
    }

    public double cost(double weight)
    {
        return strategy.calculate(weight, baseRate);
    }

    public static Optional<ShippingOrder> fromString(String s)
    {
        return Optional.ofNullable(STRING_TO_ENUM.get(s));
    }
}