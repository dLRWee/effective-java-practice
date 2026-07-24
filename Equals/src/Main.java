public class Main 
{
    public static void main(String[] args) 
    {
        User user = new User(123, "Dexter");
        AdminUser adminUser = new AdminUser(123, "Dexter", 23);
        User user2 = new User(123, "Dexter");
        
        System.out.println("Reflexive");
        System.out.println("user.equals(user): " + user.equals(user));

        System.out.println("\nSymmetric");
        System.out.println("user.equals(adminUser.asUser()): " + user.equals(adminUser.asUser()));
        System.out.println("adminUser.asUser().equals(user): " + adminUser.asUser().equals(user));

        System.out.println("\nTransitive");
        System.out.println("user.equals(adminUser):\t\t  " + user.equals(adminUser.asUser()));
        System.out.println("adminUser.asUser().equals(user2): " + adminUser.asUser().equals(user2));
        System.out.println("user.equals(user2):\t\t  " + user.equals(user2));
    }    
}
