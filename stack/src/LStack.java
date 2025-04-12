public class LStack<T> implements Stack<T> {
    private class Node {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }

    private Node head;

    public LStack() {
        head = null;
    }

    /**
     * push an element onto the stack top
     *
     * @param elem the element to be pushed
     */
    @Override
    public void push(T elem) {
        Node newNode = new Node(elem);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * pop an element from the stack top
     *
     * @return the element that's popped from the stack
     */
    @Override
    public T pop() {
        T val = head.getData();
        head = head.next;
        return val;
    }

    /**
     * peek an element from the top of the stack
     *
     * @return
     */
    @Override
    public T top() {
        return head.getData();
    }

    /**
     * check if the stack is empty
     *
     * @return if the stack is empty, return true, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
