public interface Stack<T> {
    /**
     * push an element onto the stack top
     * @param elem the element to be pushed
     */
    void push(T elem);

    /**
     * pop an element from the stack top
     * @return the element that's popped from the stack
     */
    T pop();

    /**
     * peek an element from the top of the stack
     * @return
     */
    T top();
}
