public class Main
{
    public static void main(String[] args) 
    {
        Phase.Transition first = Phase.Transition.from(Phase.SOLID, Phase.LIQUID).orElse(null);
        Phase.Transition second = Phase.Transition.from(Phase.SOLID, Phase.PLASMA).orElse(null);

        System.out.println(first);
        System.out.println(second);

        System.out.println(Phase.Transition.map);
    }
}