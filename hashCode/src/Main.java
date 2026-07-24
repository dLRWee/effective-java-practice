import java.util.HashMap;
import java.util.Map;

public class Main 
{
    public static void main(String[] args)
    {
        SmartGadget first = new SmartGadget.Builder(12, "Pum", 43.4)
            .is5GSupported(true)
            .addSensor("first")
            .addSensor("second")
            .build();

        SmartGadget second = new SmartGadget.Builder(12, "Pum", 43.4)
            .is5GSupported(true)
            .addSensor("first")
            .addSensor("second")
            .build();
        
        Map<SmartGadget, String> map = new HashMap<>();

        map.put(first, "first");

        System.out.println(map.get(second));
    }    
}