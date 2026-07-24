import java.util.EnumSet;
import java.util.Set;

public class AccessManager 
{
    public enum Permission {READ, WRITE, EXECUTE, DELETE};
    
    public void applyPermissions(Set<Permission> permissions)
    {
        System.out.println(permissions);
    }

    public static Set<Permission> inverted(Set<Permission> permissions)
    {
        EnumSet<Permission> result = EnumSet.allOf(Permission.class);
        result.removeAll(permissions);
        return result;
    }
}