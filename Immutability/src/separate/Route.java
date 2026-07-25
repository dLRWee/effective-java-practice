import java.util.ArrayList;
import java.util.List;

// Иммьютабельный класс, нельзя наследоваться
public final class Route 
{
    private final List<String> stops;
    private final double totalWeight;
    private final boolean isExpress;
    
    // Можно создать напрямую, без билдера
    public Route(List<String> stops, double totalWeight, boolean isExpress)
    {
        this.stops = List.copyOf(stops);
        this.totalWeight = totalWeight;
        this.isExpress = isExpress;

        if (totalWeight < 0)
            throw new IllegalArgumentException("Total weight: " + this.totalWeight);
    }

    public Route addStop(String stop)
    {
        List<String> newStops = new ArrayList<>(this.stops);
        newStops.add(stop);

        return new Route(newStops, this.totalWeight, this.isExpress);
    }

    public Route setWeight(double totalWeight)
    {
        if (totalWeight < 0)
            throw new IllegalArgumentException("Total weight: " + this.totalWeight);
        
        return new Route(this.stops, totalWeight, this.isExpress);
    }

    public Route isExpress(boolean state)
    {
        return new Route(this.stops, this.totalWeight, state);
    }

    // Переход в режим изменений
    public RouteBuilder toBuilder()
    {
        return new RouteBuilder(this.stops, this.totalWeight, this.isExpress);
    }

    @Override
    public String toString()
    {
        return String.format("Stops: %s\nTotal weight: %.2f\nIs express: %s", this.stops.toString(), this.totalWeight, this.isExpress);
    }
}