package second;

public class Service 
{
    @RequireRole(Role.ADMIN)
    public static void deleteUser() { }    

    @RequireRole(Role.ADMIN)
    @RequireRole(Role.USER)
    public static void writeComment() { }

    @RequireRole(Role.ADMIN)
    @RequireRole(Role.USER)
    @RequireRole(Role.GUEST)
    public static void viewPage() { }

    public static void openNewTab() { }

    public static void error() { throw new RuntimeException(); }
    
    public void nonStatic() { }
}