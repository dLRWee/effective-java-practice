import java.util.Objects;

public class User
{
    private final int id;
    private final String name;

    public User(int id, String name)
    {
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof User))
            return false;

        User user = (User) object;

        return this.id == user.id && this.name.equals(user.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.name);
    }
}