import java.util.Objects;

public class AdminUser
{
    private final User user;
    private final int accessLevel;
    
    public AdminUser(int id, String name, int accessLevel)
    {
        this.user = new User(id, name);
        this.accessLevel = accessLevel;
    }

    public User asUser()
    {
        return this.user;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof AdminUser))
            return false;

        AdminUser adminUser = (AdminUser) object;
        
        return this.user.equals(adminUser.user) && this.accessLevel == adminUser.accessLevel;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.user, this.accessLevel);
    }
}