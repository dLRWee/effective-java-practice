import java.util.Objects;

public final class SendOptions
{
    public enum Priority {LOW, NORMAL, URGENT}
    public enum Mode {NORMAL, SILENT}
    
    // Required
    private final String userId;
    private final String title;
    private final String body;
    // Optional
    private final String senderEmail;
    private final Priority priority;
    private final Mode mode;
    private final int retryCount;
    private final String theme;

    private SendOptions(SendOptions.Builder builder)
    {
        // Required
        this.userId = builder.userId;
        this.title  = builder.title;
        this.body   = builder.body;
        // Optional
        this.senderEmail = builder.senderEmail;
        this.priority    = builder.priority;
        this.mode        = builder.mode;
        this.retryCount  = builder.retryCount;
        this.theme       = builder.theme;
    }

    public String getUserId()      { return userId; }
    public String getTitle()       { return title; }
    public String getBody()        { return body; }
    public String getSenderEmail() { return senderEmail; }
    public Priority getPriority()  { return priority; }
    public Mode getMode()          { return mode; }
    public int getRetryCount()     { return retryCount; }
    public String getTheme()       { return theme; }

    /**
     * Returns a {@code SendOptions.Builder} object to construct the {@code SendOptions} instance.
     * @param userId id of the user to send
     * @param title message's title
     * @param body message's content
     * @return {@code SendOptions.Builder} object
     * @throws IllegalArgumentException if any of the parameters is {@code blank}
     * @throws NullPointerException if any of the parameters is {@code null}
     * @see SendOptions.Builder                                                                                                                          
     */
    public static Builder builder(String userId, String title, String body)
    {
        if (userId.isBlank())
            throw new IllegalArgumentException("userId is blank: " + userId);
        if (title.isBlank())
            throw new IllegalArgumentException("title is blank: " + title);
        if (body.isBlank())
            throw new IllegalArgumentException("body is blank: " + body);
        
        return new Builder(userId, title, body);
    }

    public static final class Builder
    {
        // Required
        private final String userId;
        private final String title;
        private final String body;
        // Optional
        private String senderEmail;
        private Priority priority;
        private Mode mode;
        private int retryCount;
        private String theme;

        private Builder(String userId, String title, String body)
        {
            assert !userId.isBlank();
            assert !title.isBlank();
            assert !body.isBlank();

            // Required
            this.userId = userId;
            this.title = title;
            this.body = body;
            // Optional
            this.senderEmail = "";
            this.priority    = Priority.NORMAL;
            this.mode        = Mode.NORMAL;
            this.retryCount  = 1;
            this.theme       = "";
        }

        /**
         * Set the {@code senderEmail} field.
         * @param email email address of sender
         * @return current {@code Builder} instance
         * @throws IllegalArgumentException if {@code email} is {@code blank}
         * @throws NullPointerException if {@code email} is {@code null}
         */
        public Builder senderEmail(String email)
        {
            if (email.isBlank())
                throw new IllegalArgumentException("email is blank: " + email);

            senderEmail = email;
            return this;
        }

        /**
         * Set the {@code priority} field.
         * @param priority priority of the message
         * @return current {@code Builder} instance
         * @throws NullPointerException if {@code priority} is {@code null}
         */
        public Builder priority(Priority priority)
        {
            this.priority = Objects.requireNonNull(priority);
            return this;
        }

        /**
         * Set the {@code mode} field.
         * @param mode mode of the message
         * @return current {@code Builder} instance
         * @throws NullPointerException if {@code mode} is {@code null}
         */
        public Builder mode(Mode mode)
        {
            this.mode = Objects.requireNonNull(mode);
            return this;
        }

        /**
        * Set the {@code retryCount} field.
        * @param count count of send trys
        * @return current {@code Builder} instance
        * @throws IllegalArgumentException if {@code count} is less than 0
        */
        public Builder retryCount(int count)
        {
            if (count < 0)
                throw new IllegalArgumentException("count < 0: " + count);

            retryCount = count;
            return this;
        }

        /**
         * Set the {@code theme} field.
         * @param theme theme of the message
         * @return current {@code Builder} instance
         * @throws IllegalArgumentException if {@code theme} is {@code blank}
         * @throws NullPointerException if {@code theme} is {@code null}
         */
        public Builder theme(String theme)
        {
            if (theme.isBlank())
                throw new IllegalArgumentException("email is blank: " + theme);

            this.theme = theme;
            return this;
        }

        /**
         * Returns a {@code SendOption} instance constructed with this {@code Builder} object.
         * @return a {@code SendOption} instance
         */
        public SendOptions build()
        {
            return new SendOptions(this);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("userId:\t\t").append(userId).append("\n");
        sb.append("title:\t\t").append(title).append("\n");
        sb.append("body:\t\t").append(body).append("\n");

        String tempSenderEmail = senderEmail.equals("") ? "-" : senderEmail;
        sb.append("senderEmail:\t").append(tempSenderEmail).append("\n");

        sb.append("priority:\t").append(priority).append("\n");
        sb.append("mode:\t\t").append(mode).append("\n");
        sb.append("retryCount:\t").append(retryCount).append("\n");

        String tempTheme = theme.equals("") ? "-" : theme;
        sb.append("theme:\t\t").append(tempTheme);

        return sb.toString();
    }
}