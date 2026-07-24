import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        Stack<Number> nums = new Stack<>();
        
        List<Integer> ints = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.2, 2.3, 3.1);

        nums.pushAll(ints);
        nums.pushAll(doubles);

        List<Object> dst = new ArrayList<>();

        nums.popAll(dst);

        System.out.println(dst);
    }    
}