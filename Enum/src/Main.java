public class Main 
{
    public static void main(String[] args) 
    {
        ShippingOrder order = ShippingOrder.fromString("EXPRESS").orElse(null);
        
        double cost = order.cost(78.23);

        System.out.printf("%s:\t%.2f%n%n", order.toString(), cost);

        for (ShippingOrder o : ShippingOrder.values())
        {
            System.out.printf("%s:\t%.2f%n", o.toString(), o.cost(23));
        }
    }   
}