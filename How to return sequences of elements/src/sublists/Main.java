package sublists;

import java.util.List;

class Main 
{
    public static void main(String[] args) 
    {
        List<String> list = List.of("hello", "sexter", "morgan");
        
        SubLists.of(list).forEach(System.out::println);
    }    
}