public class Main 
{
    public static void main(String[] args) 
    {
        Route first = new Route.Builder()
            .addStop("NYC")
            .addStop("Texas")   
            .totalWeight(67)
            .isExpress(true)
            .build();
        
        Route second = new Route.Builder()
            .isExpress(true)
            .build();

        second = second.toBuilder()
            .addStop("NYC")
            .addStop("Texas")
            .totalWeight(67)
            .build();

        System.out.println(first + "\n");
        System.out.println(second);
    }    
}