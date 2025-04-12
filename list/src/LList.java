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
    private int modCount;

    public LList() {
        head = null;
        size = 0;
        modCount = 0;
    }

    private class LListIterator implements Iterator<T> {
        int cur;
        Node p;
        boolean okToRemove;

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
        modCount++;
    }

    /**
     * a helper method that getNode that data == x
     *
     * @param x the data we want to find in the node
     * @return the node that contains the data
     */
    private Node getNode(T x) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            if (p.getData() == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * add a node containing data val before node p
     *
     * @param p the node to add before
     * @param val new node value
     */
    private void addBefore(Node p, T val) {
        Node newNode = new Node(val);
        if (p == null) {
            p = newNode;
        } else {
            newNode.next = p;
            newNode.prev = p.prev;
            p.prev.next = newNode;
            p.prev = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * get the node with specified index
     *
     * @param index the index of the node
     * @return the node with specified index
     */
    private Node getNode(int index) {
        if (head == null || index < 0 || index >= size) {
            return null;
        }
        Node p = head;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p;
    }

    /**
     * check if the list contains x
     *
     * @param x the item to be checked
     * @return if the list contains x, return true, otherwise return false
     */
    @Override
    public boolean contains(T x) {
        if (getNode(x) == null) {
            return false;
        }
        return true;
    }

    /**
     * add x to the end of the list
     *
     * @param x the item to be added
     * @return if successfully add x, return true, otherwise return false
     */
    @Override
    public boolean add(T x) {
        addBefore(head, x);
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
        Node p = getNode(index);
        if (p == null) {
            return false;
        }
        addBefore(p, x);
        return true;
    }

    /**
     * remove the node p
     *
     * @param p the node needs to be removed
     */
    private void remove(Node p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        modCount++;
    }

    /**
     * remove x from the list
     *
     * @param x the item to be removed
     * @return if x is successfully removed, return true, otherwise return false
     */
    @Override
    public boolean remove(T x) {
        Node p = getNode(x);
        if (p == null) {
            return false;
        }
        remove(p);
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
        Node p = getNode(index);
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
        Node p = getNode(index);
        p.setData(elem);
        modCount++;
    }

    /**
     * @return an iterator of the list
     */
    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }
}
