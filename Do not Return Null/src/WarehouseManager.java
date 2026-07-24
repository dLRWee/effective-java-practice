import java.util.*;

public class WarehouseManager 
{
    private static final String[] EMPTRY_LABEL_ARRAY = new String[0];
    
    private List<String> products = Arrays.asList("Apple", "Banana", "Orange");

    /**
     * Returns a list of products of that category or {@code Collections.emptyList()} in case there is no such products
     * @param category search parameter
     * @return a list of products that are in this {@code category}
     * @throws IllegalArgumentException if {@code category} is {@code blank}
     * @throws NullPointerException if {@code category} is {@code null}
     */
    public List<String> findProductsByCategory(String category) 
    {
        if (category.isBlank())
            throw new IllegalArgumentException("category is blank: " + category);
        
        if (category.equals("Fruit"))
        {
            return products.isEmpty() ? Collections.emptyList() : new ArrayList<>(products);
        }

        return Collections.emptyList();
    }

    /**
     * Retruns an array that contains only labels wich has {@code EXPIRED} in it.
     * @param allLabels labels to be sorted
     * @return an array with all expired labels
     * @throws NullPointerException if {@code allLabels} is {@code null}
     */
    public String[] getExpiredLabels(String[] allLabels) 
    {
        String[] result = Arrays.stream(allLabels)
                .filter(label -> label.contains("EXPIRED"))
                .toArray(String[]::new);

        return result.length == 0 ? EMPTRY_LABEL_ARRAY : result;
    }

    public static void main(String[] args) 
    {
        WarehouseManager manager = new WarehouseManager();

        // Тест 1: Списки
        List<String> results = manager.findProductsByCategory("Electronics");
        // Этот цикл не должен упасть с NullPointerException даже без проверки на null
        for (String s : results) 
        {
            System.out.println(s);
        }

        // Тест 2: Массивы
        String[] expired = manager.getExpiredLabels(new String[]{"Valid", "Fresh", "EXPIRED thing"});
        System.out.println("Найдено просрочки: " + expired.length);
    }
}
