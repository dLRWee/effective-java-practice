package processing;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class OrderProducer implements Runnable
{
    private static final String[] NAMES = 
    { 
        "Apple", "Orange", "Hammer", "Juice", "Keyboard", 
        "Garlic", "Chips", "Pen", "Book", "Phone",
        "Notebook", "Thermos", "Umbrella", "Flashlight", "Wallet",
        "Candle", "Headphones", "Backpack", "Mat", "Pillow"
    };
    
    private final MyBoundedQueue queue;

    public OrderProducer(MyBoundedQueue queue)
    {
        this.queue = Objects.requireNonNull(queue);
    }

    @Override
    public void run()
    {
        int orderCount = ThreadLocalRandom.current().nextInt(1, 21);

        for (int i = 0; i < orderCount; i++)
        {
            String name   = NAMES[ThreadLocalRandom.current().nextInt(NAMES.length)];
            long id       = ThreadLocalRandom.current().nextLong();
            double weight = ThreadLocalRandom.current().nextDouble(0.1, 100);
            
            Order order = new Order(name, id, weight);

            try
            {
                queue.put(order);
                System.out.println(Thread.currentThread().getName() + " put " + order);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}