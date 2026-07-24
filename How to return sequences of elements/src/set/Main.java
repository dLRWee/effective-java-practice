package set;

import java.util.List;
import java.util.Set;

class Main 
{
    public static void main(String[] args) 
    {
        Set<Character> set = Set.of('a', 'b', 'c');
        
        List<Set<Character>> powerSet = PowerSet.of(set);

        for (int i = 0, n = powerSet.size(); i < n; i++)
        {
            System.out.println(i + ": " + powerSet.get(i));
        }
    }    
}