import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

public class FileReader implements AutoCloseable
{
    private static final Cleaner cleaner = Cleaner.create();

    private static class FileState implements Runnable
    {
        private final String fileName;

        private FileState(String fileName)
        {
            this.fileName = fileName;
            System.out.println("File \"" + this.fileName + "\" was successfully opened!");
        }

        @Override
        public void run()
        {
            System.out.println("File \"" + this.fileName + "\" was successfully closed!");
        }
    }

    private final FileState fileState;
    private final Cleanable cleanable;

    public FileReader(String fileName)
    {
        this.fileState = new FileState(fileName);
        this.cleanable = cleaner.register(this, fileState);
    }

    @Override
    public void close()
    {
        this.cleanable.clean();
    }

    public void printFileContent()
    {
        System.out.println("Some content of the \"" + this.fileState.fileName + "\" file...");
    }
}