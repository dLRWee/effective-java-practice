import java.util.HashMap;
import java.util.Map;

public class HttpRequest
{
    public enum METHODS {GET, POST, PUT, DELETE}
    
    private final String url;                   // required
    private final METHODS method;               // required
    private final int timeout;                  // optional
    private final String body;                  // oprional
    private final Map<String, String> headers;  // optional

    public static class Builder
    {
        private final String url;                 
        private final METHODS method;             
        private int timeout;                
        private String body;                
        private Map<String, String> headers;

        public Builder(String url, METHODS method)
        {
            this.url = url;
            this.method = method;

            this.timeout = 5000;
            this.body = "";
            this.headers = new HashMap<>();
        }

        public Builder timeout(int timeout)
        {
            this.timeout = timeout;
            return this;
        }

        public Builder body(String body)
        {
            this.body = body;
            return this;
        }

        public Builder addHeader(String key, String value)
        {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequest build()
        {
            if (this.method == METHODS.GET && !this.body.isEmpty())
            {
                throw new IllegalStateException("GET request cannot have a body!");
            }
            
            return new HttpRequest(this);
        }
    }
    
    private HttpRequest(Builder builder)
    {
        this.url = builder.url;
        this.method = builder.method;
        this.timeout = builder.timeout;
        this.body = builder.body;   
        this.headers = Map.copyOf(builder.headers);
    }

    private String headersToString()
    {
        if (this.headers.isEmpty())
        {
            return "none";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (String key : this.headers.keySet())
        {
            stringBuilder.append("[" + key + " = " + this.headers.get(key) + "]\n");
        }

        return stringBuilder.toString();
    }
    
    @Override
    public String toString()
    {
        return "URL:\t\t" + this.url +
               "\nMethod:\t\t" + this.method +
               "\nTimeout:\t" + this.timeout +
               "\nBody:\t\t" + (this.body.equals("") ? "none" : this.body) + 
               "\nHeaders:\n" + this.headersToString();
    }
}