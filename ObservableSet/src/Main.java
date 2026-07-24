import java.util.HashSet;

public class Main 
{
    public static void main(String[] args) 
    {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        
        SetObserver<Integer> first = new SetObserver<Integer>() 
        {
            @Override
            public void added(ObservableSet<Integer> s, Integer element)
            {
                System.out.println(element);
                s.removeObserver(this);
            }    
        };
        
        set.addObserver(first);

        for (int i = 0; i < 10; i++)
            set.add(i);
    }    
}