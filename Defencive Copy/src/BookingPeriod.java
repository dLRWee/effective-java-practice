import java.util.Date;

public final class BookingPeriod
{
    private final Date start;
    private final Date end;

    /**
     * 
     * @param start the start time of booking period
     * @param end the end time of booking period
     * 
     * @throws IllegalArgumentException if {@code start} is greater than {@code end}
     * @throws NullPointerException if one of parameters is {@code null}
     */
    public BookingPeriod(Date start, Date end)
    {
        this.start = new Date(start.getTime());
        this.end   = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(this.start + " > " + this.end);
    }
    
    public Date getStart() { return new Date(start.getTime()); }
    public Date getEnd()   { return new Date(end.getTime()); }

    @Override
    public String toString()
    {
        return String.format("start=%s, end=%s", start, end);
    }
}