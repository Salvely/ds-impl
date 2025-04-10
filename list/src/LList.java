import java.util.Iterator;

public class LList<T> implements List<T>{
    private class LListIterator implements Iterator<T> {

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            return null;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
    /**
     * get the size of the List
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * check if the List is empty
     *
     * @return if the list is empty, return true, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {

    }

    /**
     * check if the list contains x
     *
     * @param x the item to be checked
     * @return if the list contains x, return true, otherwise return false
     */
    @Override
    public boolean contains(T x) {
        return false;
    }

    /**
     * add x to the list
     *
     * @param x the item to be added
     * @return if successfully add x, return true, otherwise return false
     */
    @Override
    public boolean add(T x) {
        return false;
    }

    /**
     * add item to position index of the list
     *
     * @param index the index of the position
     * @param x     the item to be added
     * @return if successfully added, return true, otherwise return false
     */
    @Override
    public boolean add(int index, T x) {
        return false;
    }

    /**
     * remove x from the list
     *
     * @param x the item to be removed
     * @return if x is successfully removed, return true, otherwise return false
     */
    @Override
    public boolean remove(T x) {
        return false;
    }

    /**
     * get the item at specified index
     *
     * @param index the index of the item to get
     * @return the item at the specified index
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * set the item at index to elem
     *
     * @param index the index of the item to change
     * @param elem  the new item at the index
     */
    @Override
    public void set(int index, T elem) {

    }

    /**
     * @return an iterator of the list
     */
    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }
}
