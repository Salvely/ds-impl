import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList<T> implements List<T> {
    private class Node {
        Node prev;
        T data;
        Node next;

        Node(T data) {
            this.prev = this;
            this.data = data;
            this.next = this;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public LList() {
        head = null;
        size = 0;
    }

    private class LListIterator implements Iterator<T> {
        int cur;
        Node p;

        LListIterator() {
            cur = 0;
            p = head;
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
            return cur < size;
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
                return null;
            }
            T val = p.getData();
            p = p.next;
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
            cur--;
            p.prev.prev.next = p;
            p.prev = p.prev.prev;
            size--;
        }
    }
    /**
     * get the size of the List
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * check if the List is empty
     *
     * @return if the list is empty, return true, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * check if the list contains x
     *
     * @param x the item to be checked
     * @return if the list contains x, return true, otherwise return false
     */
    @Override
    public boolean contains(T x) {
        if (head == null) {
            return false;
        }
        int n = size;
        Node p = head;
        while (n != 0) {
            if (p.getData() == x) {
                return true;
            }
            p = p.next;
            n--;
        }
        return false;
    }

    /**
     * add x to the end of the list
     *
     * @param x the item to be added
     * @return if successfully add x, return true, otherwise return false
     */
    @Override
    public boolean add(T x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
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
        if (index < 0 || index > size) {
            return false;
        }
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (index != 0) {
                index--;
                p = p.next;
            }
            newNode.next = p;
            newNode.prev = p.prev;
            p.prev.next = newNode;
            p.prev = newNode;
        }
        size++;
        return true;
    }

    /**
     * remove x from the list
     *
     * @param x the item to be removed
     * @return if x is successfully removed, return true, otherwise return false
     */
    @Override
    public boolean remove(T x) {
        if (head == null) {
            return false;
        }
        Node p = head;
        int n = size;
        while (n != 0) {
            if (p.getData() == x) {
                break;
            }
            p = p.next;
            n--;
        }
        if (n == 0) {
            return false;
        }
        p.next.prev = p.prev;
        p.prev.next = p.next;
        size--;
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
        if (index < 0 || index >= size) {
            return null;
        }
        Node p = head;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.getData();
    }

    /**
     * set the item at index to elem
     *
     * @param index the index of the item to change
     * @param elem  the new item at the index
     */
    @Override
    public void set(int index, T elem) {
        if (index < 0 || index >= size) {
            return;
        }
        Node p = head;
        while (index != 0) {
            p = p.next;
            index--;
        }
        p.setData(elem);
    }

    /**
     * @return an iterator of the list
     */
    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }
}
