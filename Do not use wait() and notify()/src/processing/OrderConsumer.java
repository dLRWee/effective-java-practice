package processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class OrderConsumer implements Runnable {
    private final MyBoundedQueue queue;
    private final List<Order> elements;

    public OrderConsumer(MyBoundedQueue queue) {
        this.queue = Objects.requireNonNull(queue);
        this.elements = new ArrayList<>();
    }

    @Override
    public void run() {
        // Консьюмер работает в цикле, пока поток не прервут из Main
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Order order = queue.take();
                System.out.println(Thread.currentThread().getName() + " took " + order);
                elements.add(order);
            }
        } catch (InterruptedException e) {
            // Ждать больше не нужно, поток завершает работу
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу. Обработано: " + elements.size());
    }
}
