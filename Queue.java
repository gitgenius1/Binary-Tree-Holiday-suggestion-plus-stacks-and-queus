import java.util.ArrayList;

public class Queue {
    private ArrayList<Integer> store;

    Queue(int capacity) {
        this.store = new ArrayList<Integer>();
    }

    public void enqueue(int value) {
        store.add(0, value);
    }

    public int dequeue() {
        return store.remove(store.size() - 1);
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }
}