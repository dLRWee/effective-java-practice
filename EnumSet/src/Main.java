import java.util.EnumSet;
import java.util.Set;

public class Main 
{
    public static void main(String[] args) 
    {
        AccessManager first = new AccessManager();
        first.applyPermissions(EnumSet.of(AccessManager.Permission.READ, AccessManager.Permission.WRITE));    

        AccessManager second = new AccessManager();
        second.applyPermissions(EnumSet.allOf(AccessManager.Permission.class)); 
        
        AccessManager third = new AccessManager();
        third.applyPermissions(EnumSet.noneOf(AccessManager.Permission.class));

        Set<AccessManager.Permission> invertedSet = AccessManager.inverted(Set.of(AccessManager.Permission.WRITE));
        System.out.println(invertedSet);
    }
}