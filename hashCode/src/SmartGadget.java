import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// final - скорее всего класс immutable (но 100% от него нельзя наследоваться)
public final class SmartGadget
{
    // кэширование хэша (так как он final, мы обязаны сделать вычисление в конструкторе)
    private final int hashCode;

    // все поля final: immutability
    private final long id;
    private final String model;
    private final double batteryLevel;
    private final boolean is5GSupported;
    private final List<String> sensors;

    // много параметров конструктора пришлось бы писать, поэтому patter builder используется
    public static class Builder
    {
        // обязательные поля - final
        private final long id;
        private final String model;
        private final double batteryLevel;
        private boolean is5GSupported;
        private List<String> sensors;

        public Builder(long id, String model, double batteryLevel)
        {
            this.id = id;
            this.model = Objects.requireNonNull(model);
            this.batteryLevel = batteryLevel;

            this.is5GSupported = false;
            this.sensors = new ArrayList<>();
        }

        public Builder is5GSupported(boolean state)
        {
            this.is5GSupported = state;
            return this;
        }

        public Builder addSensor(String sensor)
        {
            this.sensors.add(sensor);
            return this;
        }

        public SmartGadget build()
        {
            return new SmartGadget(this);
        }
    }

    public SmartGadget(Builder builder)
    {
        this.id = builder.id;
        this.model = builder.model;
        this.batteryLevel = builder.batteryLevel;
        this.is5GSupported = builder.is5GSupported;
        this.sensors = List.copyOf(builder.sensors); // возвращает immutable реализацию List (если в будущем будет геттер для этого поля, можно будет напрямую возвращать ссылку)

        int result = Long.hashCode(this.id);
        result = 31 * result + this.model.hashCode();
        result = 31 * result + Double.hashCode(this.batteryLevel);
        result = 31 * result + Boolean.hashCode(this.is5GSupported);
        result = 31 * result + this.sensors.hashCode();

        // крайне редки сучай, но почему бы не учесть
        if (result == 0)
            result = 1;
        
        this.hashCode = result;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof SmartGadget))
            return false;

        SmartGadget smartGadget = (SmartGadget) object;

        return this.id == smartGadget.id &&
               this.model.equals(smartGadget.model) &&
               Double.compare(this.batteryLevel, smartGadget.batteryLevel) == 0 &&
               this.is5GSupported == smartGadget.is5GSupported &&
               this.sensors.equals(smartGadget.sensors);
    }
    
    @Override
    public int hashCode()
    {
        // O(1): так как класс immutable, то хэш у каждого обьекта не меняется
        return this.hashCode;
    }
}