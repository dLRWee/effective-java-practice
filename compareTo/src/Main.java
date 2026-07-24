import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        List<SoftwareVersion> svs = new ArrayList<>();

        svs.add(new SoftwareVersion(1, 10, 1));
        svs.add(new SoftwareVersion(1, 2, 1));
        svs.add(new SoftwareVersion(2, 0, 0));
        svs.add(new SoftwareVersion(1, 2, 5));

        System.out.println(svs);
        svs.sort(null);
        System.out.println(svs);
    }    
}