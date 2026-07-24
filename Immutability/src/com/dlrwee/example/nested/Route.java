package com.dlrwee.example.nested;

import java.util.ArrayList;
import java.util.List;

public final class Route 
{
    private final List<String> stops;
    private final double totalWeight;
    private final boolean isExpress;
    
    private Route(List<String> stops, double totalWeight, boolean isExpress)
    {
        this.stops = List.copyOf(stops);
        this.totalWeight = totalWeight;
        this.isExpress = isExpress;
    }

    public static class Builder
    {
        private final List<String> stops;
        private double totalWeight;
        private boolean isExpress;

        public Builder()
        {
            this.stops = new ArrayList<>();
            this.totalWeight = 0;
            this.isExpress = false;
        }

        private Builder(Route route)
        {
            this.stops = new ArrayList<>(route.stops);
            this.totalWeight = route.totalWeight;
            this.isExpress = route.isExpress;
        }

        public Builder addStop(String stop)
        {
            this.stops.add(stop);
            return this;
        }

        public Builder totalWeight(double totalWeight)
        {
            if (totalWeight < 0)
                throw new IllegalArgumentException("Total weight: " + totalWeight);
            
            this.totalWeight = totalWeight;
            return this;
        }

        public Builder isExpress(boolean isExpress)
        {
            this.isExpress = isExpress;
            return this;
        }

        public Route build()
        {
            return new Route(this.stops, this.totalWeight, this.isExpress);
        }
    }

    public Builder toBuilder()
    {
        return new Builder(this);
    }

    @Override
    public String toString()
    {
        return String.format("Stops: %s\nTotal weight: %.2f\nIs express: %s", this.stops.toString(), this.totalWeight, this.isExpress);
    }
}