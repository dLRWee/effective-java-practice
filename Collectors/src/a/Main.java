package a;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.List;
import java.util.Map;

class Main 
{
    public static void main(String[] args) 
    {
        List<Order> orders = List.of
        (
            new Order("Ivan", "Electronics", 500.0),
            new Order("Maria", "Books", 50.0),
            new Order("Ivan", "Books", 30.0),
            new Order("Maria", "Electronics", 1200.0),
            new Order("Alex", "Electronics", 300.0),
            new Order("Ivan", "Electronics", 100.0)
        );    

        Map<String, Double> first = orders.stream()
            .collect(toMap(Order::customer, Order::price, Double::sum));

        Map<String, String> second = orders.stream()
            .collect(groupingBy
                (
                    Order::category, 
                    collectingAndThen(maxBy(comparingDouble(Order::price)), opt -> opt.get().customer())
                ));

        String third = orders.stream()
            .map(Order::category)
            .distinct()
            .sorted()
            .collect(joining(", ", "[", "]"));

        System.out.println("first: " + first);
        System.out.println("second: " + second);
        System.out.println("third: " + third);
    }    
}