package b;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Main 
{
    public static void main(String[] args) 
    {
        List<Book> books = List.of
        (
            new Book("Crime and Punishment", "Fyodor Dostoevsky", "Classics", 15.99),
            new Book("The Master and Margarita", "Mikhail Bulgakov", "Fantasy", 18.50),
            new Book("1984", "George Orwell", "Dystopian", 12.00),
            new Book("The Witcher: The Last Wish", "Andrzej Sapkowski", "Fantasy", 14.95),
            new Book("A Brief History of Time", "Stephen Hawking", "Science", 22.00),
            new Book("Murder on the Orient Express", "Agatha Christie", "Mystery", 11.20),
            new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "History", 25.00),
            new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Sci-Fi", 13.40),
            new Book("The Little Prince", "Antoine de Saint-Exupéry", "Fable", 9.99),
            new Book("Fight Club", "Chuck Palahniuk", "Fiction", 14.00)
        );

        Order order = new Order(books);

        List<Book> topThreeByPrice = order.books().stream()
            .distinct()
            .sorted(comparing(Book::price).reversed())
            .limit(3)
            .collect(toList());

        Map<String, Long> authorToBookCount = order.books().stream()
            .collect(groupingBy(Book::author, counting()));
        
        String theBestCategory = order.books().stream()
            .collect(groupingBy(Book::category, summingDouble(Book::price))) // Считаем выручку по жанрам
            .entrySet().stream()
            .max(Map.Entry.comparingByValue()) // Находим запись с макс. выручкой
            .map(Map.Entry::getKey)            // Берем название жанра
            .orElse("None");            // Обработка пустого списка
        
        Map<String, Set<String>> categoryToTitles = order.books().stream()
            .collect(groupingBy(Book::category, mapping(Book::title, toSet())));
            
            
        System.out.println("TOP 3 BY PRICE\n\n" + 
            topThreeByPrice.stream().map(Object::toString).collect(joining("\n")));

        System.out.println("\nAUTHOR TO BOOK COUNT\n\n" + 
            authorToBookCount.entrySet().stream().map(Object::toString).collect(joining("\n")));
        
        System.out.println("\nTHE BEST CATEGORY\n\n" + theBestCategory);

        System.out.println("\nCATEGORY TO TITLES:\n\n" + 
            categoryToTitles.entrySet().stream().map(Object::toString).collect(joining("\n")));
    }    
}