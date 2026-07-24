import java.util.Comparator;

public final class SoftwareVersion implements Comparable<SoftwareVersion>
{
    private static final Comparator<SoftwareVersion> COMPARATOR = 
        Comparator.comparingInt(SoftwareVersion::getMajor)
        .thenComparingInt(SoftwareVersion::getMinor)
        .thenComparingInt(SoftwareVersion::getPatch);

    // We can cash the hashCode because the class is immutable
    private final int hashCode;

    private final int major;    
    private final int minor;    
    private final int patch;    

    public SoftwareVersion(int major, int minor, int patch)
    {
        this.major = major;
        this.minor = minor;
        this.patch = patch;

        // Calculating hash code (for the cashing purpose)
        int value = Integer.hashCode(this.major);
        value = 31 * value + Integer.hashCode(this.minor);
        value = 31 * value + Integer.hashCode(this.patch);
        hashCode = value;
    }

    // Getters
    public int getMajor() { return this.major; }
    public int getMinor() { return this.minor; }
    public int getPatch() { return this.patch; }

    @Override
    public int compareTo(SoftwareVersion other)
    {
        return COMPARATOR.compare(this, other);
    }
    
    @Override
    public boolean equals(Object other)
    {
        if (this == other)
            return true;

        if (!(other instanceof SoftwareVersion))
            return false;

        SoftwareVersion sv = (SoftwareVersion) other;

        return this.major == sv.major &&
               this.minor == sv.minor &&
               this.patch == sv.patch;
    }

    // i did it like that because class is immutable
    @Override
    public int hashCode()
    {
        return hashCode;
    }
    
    /**
     * Returns a string representaion of the {@code SoftwareVersion} object.
     * <p>
     * The format is: {@code major.minor.patch}.
     * <p>
     * @return a string representaion of {@code this}
     */
    @Override
    public String toString()
    {
        return String.format("%d.%d.%d", this.major, this.minor, this.patch);
    }
}