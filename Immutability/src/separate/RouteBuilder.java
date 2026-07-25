import java.util.ArrayList;
import java.util.List;

// Отдельный класс
public class RouteBuilder 
{
    private List<String> stops;
    private double totalWeight;
    private boolean isExpress;  

    // Можно начинать создание с самого билдера
    public RouteBuilder()
    {
        this.stops = new ArrayList<>();
        this.totalWeight = 0;
        this.isExpress = false;
    }

    // А можно на основе уже имеющегося Route
    RouteBuilder(List<String> stops, double totalWeight, boolean isExpress)
    {
        this.stops = new ArrayList<>(stops);
        this.totalWeight = totalWeight;
        this.isExpress = isExpress;
    }

    public RouteBuilder addStop(String stop)
    {
        this.stops.add(stop);
        return this;
    }

    public RouteBuilder setWeight(double totalWeight)
    {
        if (totalWeight < 0)
            throw new IllegalArgumentException("Total weight: " + this.totalWeight);
        
        this.totalWeight = totalWeight;
        return this;
    }

    public RouteBuilder isExpress(boolean state)
    {
        this.isExpress = state;
        return this;
    }
    
    // Возвращаемся к Route
    public Route build()
    {
        return new Route(this.stops, this.totalWeight, this.isExpress);
    }
}