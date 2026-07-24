    import java.util.Objects;

    public class Author
    {
        private final String name;
        private final int age;

        public Author(String name, int age)
        {
            this.name = Objects.requireNonNull(name);
            this.age = age;
        }

        // Конструктор копирования
        public Author(Author original)
        {
            if (original == null)
                throw new IllegalArgumentException("\"original\" should not be null");
            
            this.name = original.name;
            this.age = original.age;
        }
    }