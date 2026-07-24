import java.util.Arrays;
import java.util.HashSet;

public class Main 
{
    public static void main(String[] args)
    {
        CountingSet<String> countingSet = new CountingSet<>(new HashSet<>());

        countingSet.add("Dexter");
        countingSet.add("Ellie");
        countingSet.add("House");
        countingSet.add("John");
        countingSet.remove("Dexter");

        System.out.println("Counter: " + countingSet.getCounterValue());

        String[] array = countingSet.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }    
}