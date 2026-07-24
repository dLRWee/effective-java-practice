package com.dlrwee.example.separate;

import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        Route route = new Route(List.of("Miami", "NYC"), 20, true);
        route = route.addStop("Boston");
        route = route.setWeight(30);

        Route other = new RouteBuilder()
            .addStop("Miami")
            .addStop("NYC")
            .setWeight(20)
            .isExpress(true)
            .build();

        other = other.toBuilder()
            .addStop("Boston")
            .setWeight(30)
            .build();

        System.out.println(route);
        System.out.println(other);
    }

}