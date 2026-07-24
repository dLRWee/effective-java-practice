import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;

public final class ConfigProvider
{
    private final String CONFIG_PATH = "resources\\config.txt";
    
    public String getAppVersion()
    {
        try
        {
            String version = Files.readAllLines(Path.of(CONFIG_PATH)).getFirst();
            return version;
        }
        catch (IOException e)
        {
            throw new ConfigReadException("Configuration file not found", e);
        }
        catch (NoSuchElementException e)
        {
            throw new ConfigReadException("Version info in configuration file not found", e);
        }
    }
}