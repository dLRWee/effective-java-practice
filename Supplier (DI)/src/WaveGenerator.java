import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WaveGenerator 
{
    private final Supplier<? extends Enemy> enemyFactory;
    
    public WaveGenerator(Supplier<? extends Enemy> enemyFactory)
    {
        this.enemyFactory = enemyFactory;
    }

    public List<Enemy> createWave(int count)
    {
        List<Enemy> wave = new ArrayList<>();

        for (int i = 0; i < count; i++)
        {
            wave.add(enemyFactory.get());
        }

        return wave;
    }
}