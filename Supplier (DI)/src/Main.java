import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        WaveGenerator dragonsGen = new WaveGenerator(Dragon::new);
        List<Enemy> dragons = dragonsGen.createWave(2);
        
        WaveGenerator orcsGen = new WaveGenerator(Orc::new);
        List<Enemy> orcs = orcsGen.createWave(4);

        dragons.forEach(Enemy::attack);
        orcs.forEach(Enemy::attack);
    }    
}