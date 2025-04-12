public class AStack<T> implements Stack<T> {
    private int capacity;
    private int base;
    private int top;
    private T[] arr;

    public AStack(int capacity) {
        this.capacity = capacity;
        this.base = 0;
        this.top = 0;
        this.arr = (T[]) new Object[capacity];
    }

    /**
     * check if the stack is empty
     * @return if the stack is empty, return true, otherwise return false
     */
    public boolean isEmpty() {
        return base == top;
    }

    /**
     * check if the stack is full
     * @return if the stack if full, return true, otherwise return false
     */
    public boolean isFull() {
        return top == capacity;
    }

    /**
     * push an element onto the stack top
     *
     * @param elem the element to be pushed
     */
    @Override
    public void push(T elem) {
        if (isFull()) {
            return;
        }
        arr[top] = elem;
        top++;
    }

    /**
     * pop an element from the stack top
     *
     * @return the element that's popped from the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        return arr[top];
    }

    /**
     * peek an element from the top of the stack
     *
     * @return
     */
    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return arr[top - 1];
    }
}
