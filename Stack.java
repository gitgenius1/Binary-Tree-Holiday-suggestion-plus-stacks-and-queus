public class Stack<T> {
    private T[] store;
    private int count;

    Stack(int capacity) {
        // this.store = new T[capacity];
        this.count = 0;
    }

    public void push(T value) {
        store[count] = value;
        count++;
    }

    public T pop() {
        count--;
        return store[count];
    }

    public T peek() {
        return store[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }
}