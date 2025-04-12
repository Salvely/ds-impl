public class DoubleEndedQueue<T> {
    private T[] queue;
    private int head;
    private int tail;
    private int capacity;
    int size;

    public DoubleEndedQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public void enqueue(T elem) {
        if(isFull()) {
            System.out.println("The queue is full, cannot add more.");
            return;
        }
        queue[tail] = elem;
        tail = (tail + 1) % capacity;
        size++;
    }

    public T dequeue() {
        if(isEmpty()) {
            System.out.println("The queue is empty, cannot delete.");
            return null;
        }
        T val = queue[head];
        head = (head + 1) % capacity;
        size--;
        return val;
    }

    public int size() {
        return size;
    }
}
