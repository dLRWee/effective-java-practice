package second;

class Main 
{
    static void main(String[] args)
    {
        MiniCache<Integer> cache = new MiniCache<>(10);

        cache.add(1);
        cache.add(2);
        cache.add(3);

        for (int i = 0; i < 3; i++)
        {
            System.out.println(cache.get(i) * 2);
        }
    }    
}