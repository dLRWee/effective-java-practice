package processing;

import java.util.ArrayList;
import java.util.List;

public final class MyBoundedQueue {
    private final int capacity;
    private final List<Order> elements;

    public MyBoundedQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    public synchronized void put(Order e) throws InterruptedException {
        while (elements.size() == capacity) {
            wait();
        }
        elements.add(e);
        notifyAll();
    }

    public synchronized Order take() throws InterruptedException {
        while (elements.isEmpty()) {
            wait();
        }
        // removeLast() возвращает элемент И удаляет его из списка
        Order result = elements.removeLast(); 
        notifyAll();
        return result;
    }
}
