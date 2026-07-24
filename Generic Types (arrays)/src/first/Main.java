package first;

class Main 
{
    static void main(String[] args) 
    {
        MiniCache<String> cache = new MiniCache<>(10);

        cache.add("first");
        cache.add("second");
        cache.add("third");

        for (int i = 0; i < 3; i++)
        {
            System.out.println(cache.get(i).toUpperCase());
        }
    }    
}