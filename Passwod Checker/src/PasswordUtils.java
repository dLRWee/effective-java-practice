import java.util.regex.Pattern;

public class PasswordUtils 
{
    private PasswordUtils()
    {
        throw new AssertionError("Cannot make instance of the \"PasswordUtils\" class.");
    }    

    private final static int MIN_LENGTH = 8;
    private final static Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{" + MIN_LENGTH + ",}$");
}