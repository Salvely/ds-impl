import java.util.Iterator;
import java.util.NoSuchElementException;

public class AList<T> implements List<T> {
    private T[] arr;
    private int capacity;
    private int num;

    public AList(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        num = 0;
    }

    public void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < capacity; i++) {
            newArr[i] = arr[i];
        }
        capacity = newSize;
        arr = newArr;
    }

    private class AListIterator implements Iterator<T> {
        int cur;

        AListIterator() {
            cur = 0;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return !(cur == num);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T val = arr[cur];
            cur++;
            return val;
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
         */
        @Override
        public void remove() {
            AList.this.remove(--cur);
        }
    }

    /**
     * get the size of the List
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return num;
    }

    /**
     * check if the List is empty
     *
     * @return if the list is empty, return true, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return num == 0;
    }

    /**
     * check if the arraylist is full
     * @return if the arraylist if full, return true, otherwise return false
     */
    public boolean isFull() {
        return num == capacity;
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {
        num = 0;
    }

    /**
     * check if the list contains x
     *
     * @param x the item to be checked
     * @return if the list contains x, return true, otherwise return false
     */
    @Override
    public boolean contains(T x) {
        for (T item: arr) {
            if (item == x) {
                return true;
            }
        }
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
        if (isFull()) {
            resize(capacity * 2);
        }
        arr[num] = x;
        num++;
        return true;
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
        if (isFull()) {
            resize(capacity * 2);
        }
        for (int i = num; i >= index + 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = x;
        num++;
        return true;
    }

    /**
     * remove the item at index
     * @param index the index of the item to be removed
     */
    public void remove(int index) {
        if (isEmpty()) {
            return;
        }
        for (int i = index; i < num - 1; i++) {
            arr[i] = arr[i + 1];
        }
        num--;
    }

    /**
     * remove x from the list
     *
     * @param x the item to be removed
     * @return if x is successfully removed, return true, otherwise return false
     */
    @Override
    public boolean remove(T x) {
        if (isEmpty()) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < num; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * get the item at specified index
     *
     * @param index the index of the item to get
     * @return the item at the specified index
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= num) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * set the item at index to elem
     *
     * @param index the index of the item to change
     * @param elem  the new item at the index
     */
    @Override
    public void set(int index, T elem) {
        if (index < 0 || index >=  num) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = elem;
    }

    /**
     * @return an iterator of the list
     */
    @Override
    public Iterator<T> iterator() {
        return new AListIterator();
    }
}
