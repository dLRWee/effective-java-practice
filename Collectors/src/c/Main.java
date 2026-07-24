package c;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

class Main 
{
    public static void main(String[] args) 
    {
        List<Order> orders = getOrders();

        Map<String, List<String>> first = mapCategoryToName(orders);
        Map<String, Double> second = mapCategoryToTotalPrice(orders);

        System.out.println(first + "\n");
        System.out.println(second);
    }
    
    private static Map<String, List<String>> mapCategoryToName(List<? extends Order> orders)
    {
        Map<String, List<String>> result = orders.stream()
            .collect(groupingBy(Order::category, mapping(Order::productName, toList())));

        return result;
    }

    private static Map<String, Double> mapCategoryToTotalPrice(List<? extends Order> orders)
    {
        Map<String, Double> result = orders.stream()
            .collect(groupingBy(Order::category, summingDouble(Order::price)));

        return result;
    }
    
    private static List<Order> getOrders()
    {
        List<Order> result = List.of
        (
            new Order("Electronics", "iPhone", 1000.0),
            new Order("Electronics", "Headphones", 200.0),
            new Order("Food", "Apple", 2.0),
            new Order("Food", "Bread", 1.5),
            new Order("Books", "Clean Code", 40.0)
        );

        return result;
    }
}